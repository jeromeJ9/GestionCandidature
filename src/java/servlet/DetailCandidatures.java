package servlet;

import bean.LesSessionsCandidates;
import bean.Personne;
import bean.SessionCandidate;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DetailCandidatures", urlPatterns = {"/DetailCandidatures"})
public class DetailCandidatures extends HttpServlet {
    private String idSession = null;
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            idSession = (String) request.getParameter("idSession");
            SessionCandidate uneSession = null;
            int id = Integer.parseInt(idSession);
            uneSession = dao.Session.getCandidatsBySession(id);
            
            request.setAttribute("detailsSession", uneSession);
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DetailCandidatures.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/DetailSession.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(idSession);
        SessionCandidate uneSession; 
        try {
            uneSession = dao.Session.getCandidatsBySession(id);
            for (Personne unePersonne : uneSession.getListeDePersonnes()){
                int idPersonI = unePersonne.getId();
                String idPersonS = Integer.toString(idPersonI);
                String etatCandidat = (String) request.getParameter(idPersonS);
                int etatCandidature = Integer.parseInt(etatCandidat);
                dao.Candidature.setEtatCandidatureByIdPersonneAndIdSession(idPersonI, id, etatCandidature);
                
            } 
        }catch (SQLException ex) {
                Logger.getLogger(DetailCandidatures.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect(request.getContextPath() + "/AffichageSessions");
    }
       
   

}
