package bean;

import java.util.ArrayList;
import java.util.List;

public class LesSessionsCandidates {
    private List<SessionCandidate> listeSessionsCandidates = new ArrayList<SessionCandidate>();

   

    public LesSessionsCandidates() {
    }

    public List<SessionCandidate> getListeSessionsCandidates() {
        return listeSessionsCandidates;
    }

    public void setListeSessionsCandidates(SessionCandidate uneSession) {
        listeSessionsCandidates.add(uneSession);
    }
    
    
}
