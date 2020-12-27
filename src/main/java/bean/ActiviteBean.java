package bean;

import java.util.Date;

public class ActiviteBean {

    private Date date;
    private String heureDebut;
    private String heureFin;
    private String lieu;
    private String adresse;
    private int id;

    public ActiviteBean(){
        this.date = null;
        this.heureDebut = null;
        this.heureFin = null;
        this.lieu = null;
        this.adresse = null;
    }

    public Date getDate() { return this.date; }
    public String getHeureDebut() { return this.heureDebut; }
    public String getHeureFin() { return this.heureFin; }
    public String getLieu() { return this.lieu; }
    public String getAdresse() {return this.adresse; }
    public int getId() {return this.id; }

    public void setDate(Date date) { this.date = date; }
    public void setHeureDebut(String heureDebut) { this.heureDebut = heureDebut; }
    public void setHeureFin(String heureFin) { this.heureFin = heureFin; }
    public void setLieu(String lieu) { this.lieu = lieu; }
    public void setAdresse(String adresse) {this.adresse = adresse; }
    public void setId(int id) { this.id = id; }

}
