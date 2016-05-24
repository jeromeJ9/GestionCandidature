package service;

import bean.Candidat;
import bean.UneSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LesServicesGestion {
    
    
    public List<UneSession> getAllSessions() throws SQLException{
        int nbSession = 0;
        UneSession uneSession = null;
        List<UneSession> lesSessions = new ArrayList<UneSession>();
        nbSession = dao.LesSessions.getNombreSessions();
            for(int i = 1; i < nbSession+1; i++){
                uneSession = dao.Session.getCandidatsBySession(i);
                lesSessions.add(uneSession);
            }
        return lesSessions;
    }
    
 /*
    public List<Candidat> getCandidatValideBySession (List<Candidat> listePersonne) throws SQLException{
        List<Candidat> lesCandidats = new ArrayList<Candidat>();
        for ( Candidat unPerso : listePersonne )
            if (unPerso.getId_etatCandidature() == 2){
                lesCandidats.add(unPerso);
            }
        return lesCandidats;
    }
    
    public int getNbCandidatValideBySession (int id) throws SQLException {
        UneSession session = dao.Session.getCandidatsBySession(id);
        int compteur = 0;
        for ( Candidat unCandidat : session.getListeDePersonnes())
            if (unCandidat.getId_etatCandidature() == 2){
                compteur++;
            }
        return compteur;
    }
    */
    
    
    public int getMaxIdCandidatBySession (int id) throws SQLException {
        UneSession session = dao.Session.getCandidatsBySession(id);
        int max = 0;
        for ( Candidat unCandidat : session.getListeDePersonnes())
            if (unCandidat.getId() > max){
                max =unCandidat.getId() ;
            }
        return max;
    }
    
    public HashMap<String, List<String> > getListeSessionCandidateByCandidat (int idCandidat) throws SQLException{
        List<UneSession> lesSessions = getAllSessions();
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
    
   
}