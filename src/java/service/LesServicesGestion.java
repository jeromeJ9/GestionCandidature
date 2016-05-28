package service;

import bean.Candidat;
import bean.UneSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LesServicesGestion implements ServiceGestionCandidature{
    
    
    public List<UneSession> getAllSessionsWithCandidats() throws SQLException{
        int nbSession = 0;
        UneSession uneSession = null;
        List<UneSession> lesSessions = new ArrayList<UneSession>();
        nbSession = dao.LesSessions.getNombreSessions();
            for(int i = 1; i < nbSession+1; i++){
                uneSession = dao.Session.getSessionWithCandidats(i);
                lesSessions.add(uneSession);
            }
        return lesSessions;
    }
    

    
    
    public int getMaxIdCandidatBySession (int id) throws SQLException {
        UneSession session = dao.Session.getSessionWithCandidats(id);
        int max = 0;
        for ( Candidat unCandidat : session.getListeDePersonnes())
            if (unCandidat.getId() > max){
                max =unCandidat.getId() ;
            }
        return max;
    }
    
    public HashMap<String, List<String> > getListeSessionCandidateByCandidat (int idCandidat) throws SQLException{
        List<UneSession> lesSessions = getAllSessionsWithCandidats();
        HashMap<String, List<String> > laListeSessionCandidate = new HashMap<String, List<String>>(); 
        for (UneSession uneSession : lesSessions){
            for (Candidat unCandidat : uneSession.getListeDePersonnes()){
                if (unCandidat.getId() == idCandidat ){
                    List<String> uneListe = new ArrayList<String>();
                    uneListe.add(unCandidat.getEtatCandidature());
                    uneListe.add(uneSession.getDateSessionMA());
                    laListeSessionCandidate.put(uneSession.getIntituleSession(), uneListe);
                }
            }
        }
        return laListeSessionCandidate;
    }
    
    public UneSession getSessionWithCandidats (int idSession) throws SQLException{
        return dao.Session.getSessionWithCandidats(idSession);
    }
    public void setEtatCandidatureByIdPersonneAndIdSession(int idPersonne,int idSession, int etatCandidature) throws SQLException{
        dao.Candidature.setEtatCandidatureByIdPersonneAndIdSession(idPersonne, idSession, etatCandidature);
    }
   
}