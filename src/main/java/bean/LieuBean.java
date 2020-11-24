package bean;

public class LieuBean {

    private String nom;
    private String adresse;

    public LieuBean(){
        this.nom = null;
        this.adresse = null;
    }


    public String getNom() { return this.nom; }
    public String getAdresse() { return this.adresse; }

    public void setNom(String nom) { this.nom = nom; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
}
