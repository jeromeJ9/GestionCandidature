package bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class UneSession {
    private int idSession;
    private String intituleSession;
    private int nbPlaces;
    private List<Candidat> listeDePersonnes;
    private String dateDebutSessionJMA;
    private String dateSessionMA;
    private String debutInscription;
    private String finInscription;

    public UneSession() {
    }
    
    public UneSession(int idSession, String intituleSession, List<Candidat> listeDePersonnes, int nbPlaces, Date dateDebutSession,Date debutInscription,Date finInscription ) {
        this.idSession = idSession;
        this.intituleSession = intituleSession;
        this.listeDePersonnes = listeDePersonnes;
        this.nbPlaces = nbPlaces;
        this.dateDebutSessionJMA = formatDateJMA(dateDebutSession);
        this.dateSessionMA = formatDateMA(dateDebutSession);
        this.debutInscription = formatDateJMA(debutInscription);
        this.finInscription = formatDateJMA(finInscription);
       
    }
    

    public int getIdSession() {
        return idSession;
    }
    public String getIntituleSession() {
        return intituleSession;
    }
    public List<Candidat> getListeDePersonnes() {
        return listeDePersonnes;
    }
    public int getNbPlaces() {
        return nbPlaces;
    }
    public String getDateDebutSessionJMA() {
        return dateDebutSessionJMA;
    }
    public String getDateSessionMA() {
        return dateSessionMA;
    }
    public String getDebutInscription() {
        return debutInscription;
    }
    public String getFinInscription() {
        return finInscription;
    }
    
    public int getNbPlacesRestantes(){
        return nbPlaces-getNbInscrit();
    }
    
    public int getNbInscrit(){
        List<Candidat> lesPersonnesInscrites = new ArrayList<Candidat>();
        for (Candidat unePerso : listeDePersonnes){
            if (unePerso.getId_etatCandidature() == 2)
                lesPersonnesInscrites.add(unePerso);
        }
        return lesPersonnesInscrites.size();
    }
   
    private String formatDateJMA(Date date){
        Calendar moisJour = new GregorianCalendar();
        moisJour.setTime(date);
        return (moisJour.get(Calendar.DAY_OF_MONTH)+"/"+(moisJour.get(Calendar.MONTH)+1)+"/"+moisJour.get(Calendar.YEAR));
        
        
    }
    
    private String formatDateMA(Date date){
        String mois = null;
        Calendar moisJour = new GregorianCalendar();
        moisJour.setTime(date);
        switch (moisJour.get(Calendar.MONTH)+1) {
            case 1:
                mois = "janvier";
                break;
            case 2:
                mois = "fevrier";
                break;
            case 3:
                mois = "mars";
                break;
            case 4:
                mois = "avril";
                break;
            case 5:
                mois = "mai";
                break;
            case 6:
                mois = "juin";
                break;
            case 7:
                mois = "juillet";
                break;
            case 8:
                mois = "aout";
                break;
            case 9:
                mois = "septembre";
                break;
            case 10:
                mois = "octobre";
                break;
            case 11:
                mois = "novembre";
                break;
            case 12:
                mois = "decembre";
                break;
            default:
                break;
        }
        
        return ( mois+" " +moisJour.get(Calendar.YEAR));
        
        
    }

    @Override
    public String toString() {
        return "SessionCandidate{" + "idSession=" + idSession + ", intituleSession=" + intituleSession + ", nbPlaces=" + nbPlaces + ", listeDePersonnes=" + listeDePersonnes + ", dateDebutSessionJMA=" + dateDebutSessionJMA + ", dateSessionMA=" + dateSessionMA + ", debutInscription=" + debutInscription + ", finInscription=" + finInscription + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idSession;
        hash = 53 * hash + (this.intituleSession != null ? this.intituleSession.hashCode() : 0);
        hash = 53 * hash + this.nbPlaces;
        hash = 53 * hash + (this.listeDePersonnes != null ? this.listeDePersonnes.hashCode() : 0);
        hash = 53 * hash + (this.dateDebutSessionJMA != null ? this.dateDebutSessionJMA.hashCode() : 0);
        hash = 53 * hash + (this.dateSessionMA != null ? this.dateSessionMA.hashCode() : 0);
        hash = 53 * hash + (this.debutInscription != null ? this.debutInscription.hashCode() : 0);
        hash = 53 * hash + (this.finInscription != null ? this.finInscription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UneSession other = (UneSession) obj;
        if (this.idSession != other.idSession) {
            return false;
        }
        if (this.nbPlaces != other.nbPlaces) {
            return false;
        }
        if ((this.intituleSession == null) ? (other.intituleSession != null) : !this.intituleSession.equals(other.intituleSession)) {
            return false;
        }
        if ((this.dateDebutSessionJMA == null) ? (other.dateDebutSessionJMA != null) : !this.dateDebutSessionJMA.equals(other.dateDebutSessionJMA)) {
            return false;
        }
        if ((this.dateSessionMA == null) ? (other.dateSessionMA != null) : !this.dateSessionMA.equals(other.dateSessionMA)) {
            return false;
        }
        if ((this.debutInscription == null) ? (other.debutInscription != null) : !this.debutInscription.equals(other.debutInscription)) {
            return false;
        }
        if ((this.finInscription == null) ? (other.finInscription != null) : !this.finInscription.equals(other.finInscription)) {
            return false;
        }
        if (this.listeDePersonnes != other.listeDePersonnes && (this.listeDePersonnes == null || !this.listeDePersonnes.equals(other.listeDePersonnes))) {
            return false;
        }
        return true;
    }

    
    
   
    
}
