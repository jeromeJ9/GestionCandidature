package servlet;

import bean.Candidat;
import bean.UneSession;
import java.io.IOException;
import java.sql.SQLException;
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
    private int idSessionInt = 0;
    private LesServicesGestion serv;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        serv = new LesServicesGestion();
       
        
        // Affichage de tous les candidats d'une session dont id est en parametre idSession
        try {
            idSession = (String) request.getParameter("idSession");
            idSessionInt = Integer.parseInt(idSession);
            UneSession uneSession = serv.getSessionWithCandidats(idSessionInt);    
            request.setAttribute("detailsSession", uneSession);
            
        } catch (SQLException ex) {
            Logger.getLogger(DetailCandidatures.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //  requete get de la JSP DetailSession pour afficher les autres candidatures d'un candidat avec parametre idCandidat
        String idPersonneForDetail = (String)request.getParameter("idCandidat");
        if ( idPersonneForDetail != null){
            request.setAttribute("idCandidatPourDetail", idPersonneForDetail);
            int idPersonneForDetailInt = Integer.parseInt(idPersonneForDetail);
            
            try {
                HashMap<String, List<String> > lesSessionsCandidates = null;
                lesSessionsCandidates = serv.getListeSessionCandidateByCandidat(idPersonneForDetailInt);
                request.setAttribute("listeCandidature", lesSessionsCandidates);
               
            } catch (SQLException ex) {
                Logger.getLogger(DetailCandidatures.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // attribute set par la methode POST de cette class
        if(request.getParameter("tropInscris") != null)
            request.setAttribute("tropInscris", request.getParameter("tropInscris"));
        
        getServletContext().getRequestDispatcher("/WEB-INF/DetailSession.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // traitement de l'enregistrement de tous les etats de candidatures de tous les candidats d'une session
            // renvoyé par le formulaire dans une liste de bouton radio ou ->
            //                  le name est l'id du candidat et la valeur l'etat de candidature
            int compteur =0;
            // on compte le nombre de candidats validés
            System.out.println("idsession"+idSessionInt);
            for ( int i =1; i <= serv.getMaxIdCandidatBySession(idSessionInt); i++ ){
                String idPerson = Integer.toString(i);
                if ("2".equals((String) request.getParameter(idPerson)) ){
                    compteur++;
                }
            }
            // on verifie qu'il y a suffisamment de place dispo
            UneSession session = serv.getSessionWithCandidats(idSessionInt);
            if (compteur <= session.getNbPlaces()){ 
                for (Candidat unePersonne : session.getListeDePersonnes()){
                String idPersonS = Integer.toString(unePersonne.getId());
                String etatCandidat = (String) request.getParameter(idPersonS);
                    if (etatCandidat != null){
                        int etatCandidature = Integer.parseInt(etatCandidat);
                        serv.setEtatCandidatureByIdPersonneAndIdSession(unePersonne.getId(), idSessionInt, etatCandidature);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/AffichageSessions");
            }
            // sinon on re-affiche la liste initial des candidature ( avant check de bouton radio )
            else {
                response.sendRedirect(request.getContextPath() + "/DetailCandidatures?tropInscris=true&idSession="+idSessionInt);
                  
            }
            
        
        
        }catch (SQLException ex) {
                Logger.getLogger(DetailCandidatures.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
       
   

}
