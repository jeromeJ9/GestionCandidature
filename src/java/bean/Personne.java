package bean;


public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private int id_etatCandidature;

    public Personne(int id,String nom, String prenom, int id_etatCandidature) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.id_etatCandidature = id_etatCandidature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId_etatCandidature() {
        return id_etatCandidature;
    }

    public void setId_etatCandidature(int id_etatCandidature) {
        this.id_etatCandidature = id_etatCandidature;
    }
    
    
}
