
package service;

import bean.UneSession;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface ServiceGestionCandidature {
    public List<UneSession> getAllSessionsWithCandidats() throws SQLException;
    
    public int getMaxIdCandidatBySession (int id) throws SQLException; 
    
    public HashMap<String, List<String> > getListeSessionCandidateByCandidat (int idCandidat) throws SQLException;
    
    public UneSession getSessionWithCandidats (int idSession) throws SQLException;

    public void setEtatCandidatureByIdPersonneAndIdSession(int idPersonne,int idSession, int etatCandidature) throws SQLException;
}
