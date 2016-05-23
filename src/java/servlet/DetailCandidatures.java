package servlet;

import bean.Candidat;
import bean.UneSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LesServicesGestion;


@WebServlet(name = "DetailCandidatures", urlPatterns = {"/DetailCandidatures"})
public class DetailCandidatures extends HttpServlet {
    private String idSession = null;
    private int nbPlacesDispo = 0;
    private int idSessionInt = 0;
    private LesServicesGestion serv;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        serv = new LesServicesGestion();
        // demande d'affichage de tous les candidats d'une session donnée
        try {
            idSession = (String) request.getParameter("idSession");
            UneSession uneSession = null;
            int id = Integer.parseInt(idSession);
            uneSession = dao.Session.getCandidatsBySession(id);     /////le service ???,
            request.setAttribute("detailsSession", uneSession);
            
        } catch (SQLException ex) {
            Logger.getLogger(DetailCandidatures.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
        
        // #### requete get de la JSP DetailSession pour afficher les autres candidatures d'un candidat
        String idPersonneForDetail = (String)request.getParameter("personne");
        
        if ( idPersonneForDetail != null){
            request.setAttribute("detail", idPersonneForDetail);
            int idPersonneForDetailInt = Integer.parseInt(idPersonneForDetail);
            
            try {/*
                List<UneSession> sessions = new ArrayList<UneSession>();
                sessions = dao.Session.getSessionCandidateByPersonne(idPersonneForDetailInt);
                request.setAttribute("listeCandidature", sessions);
                */
            HashMap<String, List<String> > lesSessionsCandidates = new HashMap<String, List<String>>();
            lesSessionsCandidates = serv.getListeSessionCandidateByCandidat(idPersonneForDetailInt);
                request.setAttribute("listeCandidature", lesSessionsCandidates);
               
            } catch (SQLException ex) {
                Logger.getLogger(DetailCandidatures.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        
        if(request.getParameter("tropInscris") != null)
            request.setAttribute("tropInscris", request.getParameter("tropInscris"));
        
        
        
        
        
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/DetailSession.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        // traitement de l'enregistrement de tous les etats de candidatures de tous les candidats d'une session
        if (Integer.parseInt(idSession) != 0)
            idSessionInt = Integer.parseInt(idSession);
        UneSession uneSession = null;
      
            
          
            UneSession session = dao.Session.getCandidatsBySession(idSessionInt);
            int compteur =0;
            for ( int i =1; i <= serv.getMaxIdCandidatBySession(idSessionInt); i++ ){
                String idPerson = Integer.toString(i);
                if ("2".equals((String) request.getParameter(idPerson)) ){
                    compteur++;
                }
            }
            if (compteur <= session.getNbPlaces()){
                for (Candidat unePersonne : session.getListeDePersonnes()){
                String idPersonS = Integer.toString(unePersonne.getId());
                String etatCandidat = (String) request.getParameter(idPersonS);
                  if (etatCandidat != null){
                        int etatCandidature = Integer.parseInt(etatCandidat);
                        dao.Candidature.setEtatCandidatureByIdPersonneAndIdSession(unePersonne.getId(), idSessionInt, etatCandidature);
                  }
                }
                response.sendRedirect(request.getContextPath() + "/AffichageSessions");
            }
            else {
                
                    request.setAttribute("tropDeValidation", uneSession);
                    response.sendRedirect(request.getContextPath() + "/DetailCandidatures?tropInscris=true&idSession="+idSessionInt);
                  
            }
            
        
        
        }catch (SQLException ex) {
                Logger.getLogger(DetailCandidatures.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
       
   

}
