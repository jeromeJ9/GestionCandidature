package servlet;

import bean.LesSessionsCandidates;
import bean.Personne;
import bean.SessionCandidate;
import dao.LesSessions;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AfficheLesSessions", urlPatterns = {"/AffichageSessions"})
public class AfficheLesSessions extends HttpServlet {

   
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nbSession = 0;
        SessionCandidate uneSession = null;
        LesSessionsCandidates lesSessions = new LesSessionsCandidates();
        try {
            nbSession = dao.LesSessions.getNombreSessions();
            for(int i = 1; i < nbSession+1; i++){
                uneSession = dao.Session.getCandidatsBySession(i);
                for (int j =0; j < uneSession.getListeDePersonnes().size(); j++){
                    Personne per = uneSession.getListeDePersonnes().get(j);
                    uneSession.nbCandidatsInscrits();
                }
                 lesSessions.setListeSessionsCandidates(uneSession);
            }
            
             
             
             
        } catch (SQLException ex) {
            Logger.getLogger(AfficheLesSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("LesSessionsCandidates", lesSessions.getListeSessionsCandidates());
        //System.out.println("nombreSessions"+uneSession.getIntituleSession());
        getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


}
