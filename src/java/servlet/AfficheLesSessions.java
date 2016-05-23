package servlet;

import bean.Candidat;
import bean.UneSession;
import dao.LesSessions;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LesServicesGestion;


@WebServlet(name = "AfficheLesSessions", urlPatterns = {"/AffichageSessions"})
public class AfficheLesSessions extends HttpServlet {
   
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        List<UneSession> lesSessions = null;
        
        
        //setAttribute toutes les sessions
        try {
            LesServicesGestion service = new LesServicesGestion();
            lesSessions = service.getAllSessions();
            request.setAttribute("LesSessionsCandidates", lesSessions);
        }catch (SQLException ex) {
            Logger.getLogger(AfficheLesSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        //   retour de la jsp pour details d'une session

        int idSession =0;
        if (request.getParameter("session") != null ){
            idSession = Integer.parseInt((String)request.getParameter("session"));
             
            for (UneSession laSession : lesSessions){   
                if (laSession.getIdSession() == idSession){
                    request.setAttribute("laSessionDemandee", laSession);
                }
            }
        }
            
            
        getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
         
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


}
