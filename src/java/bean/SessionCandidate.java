package bean;

import java.util.List;

public class SessionCandidate {
    private int idSession;
    private String intituleSession;
    private int nbPlaces;
    private List<Personne> listeDePersonnes;
    private int candidatsInscrits;

    public SessionCandidate() {
    }

    
    
    public SessionCandidate(int idSession, String intituleSession, List<Personne> listeDePersonnes, int nbPlaces) {
        this.idSession = idSession;
        this.intituleSession = intituleSession;
        this.listeDePersonnes = listeDePersonnes;
        this.nbPlaces = nbPlaces;
    }

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    public String getIntituleSession() {
        return intituleSession;
    }

    public void setIntituleSession(String intituleSession) {
        this.intituleSession = intituleSession;
    }

    public List<Personne> getListeDePersonnes() {
        return listeDePersonnes;
    }

    public void setListeDePersonnes(List<Personne> listeDePersonnes) {
        this.listeDePersonnes = listeDePersonnes;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public int getCandidatsInscrits() {
        return candidatsInscrits;
    }

    public void setCandidatsInscrits(int candidatsInscrits) {
        this.candidatsInscrits = candidatsInscrits;
    }
    
    public void nbCandidatsInscrits(){
        int nbInscrits = 0;
        for (Personne unePerso : listeDePersonnes){
            if (unePerso.getId_etatCandidature() == 2)
                nbInscrits++;
        }
        this.candidatsInscrits = nbInscrits;
    }
}
