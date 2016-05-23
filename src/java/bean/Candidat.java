package bean;


public class Candidat {
    private int id;
    private String nom;
    private String prenom;
    private int id_etatCandidature;
    private String etatCandidature;

    public Candidat(int id_etatCandidature) {
        this.id_etatCandidature = id_etatCandidature;
        
    }
    public Candidat(int id,String nom, String prenom, int id_etatCandidature) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.id_etatCandidature = id_etatCandidature;
        this.etatCandidature = getEtatCandid(id_etatCandidature);
        
    }

    public int getId() {
        return id;
    }

   
    public String getNom() {
        return nom;
    }

   
    public String getPrenom() {
        return prenom;
    }

    public int getId_etatCandidature() {
        return id_etatCandidature;
    }

   

    public String getEtatCandidature() {
        return etatCandidature;
    }
    
    public String getEtatCandid ( int etat){
        switch (etat) {
            case 1:
                return "En attente";
            case 2:
                return "Validée";
            case 3:
                return "Refusé";
            default:
                return "En attente de traitement";
        }
        
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", id_etatCandidature=" + id_etatCandidature + ", etatCandidature=" + etatCandidature + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        hash = 53 * hash + (this.nom != null ? this.nom.hashCode() : 0);
        hash = 53 * hash + (this.prenom != null ? this.prenom.hashCode() : 0);
        hash = 53 * hash + this.id_etatCandidature;
        hash = 53 * hash + (this.etatCandidature != null ? this.etatCandidature.hashCode() : 0);
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
        final Candidat other = (Candidat) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_etatCandidature != other.id_etatCandidature) {
            return false;
        }
        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
            return false;
        }
        if ((this.prenom == null) ? (other.prenom != null) : !this.prenom.equals(other.prenom)) {
            return false;
        }
        if ((this.etatCandidature == null) ? (other.etatCandidature != null) : !this.etatCandidature.equals(other.etatCandidature)) {
            return false;
        }
        return true;
    }

       
}
