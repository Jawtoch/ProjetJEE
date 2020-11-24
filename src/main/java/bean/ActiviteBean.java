package bean;

import java.util.Date;

public class ActiviteBean {

    private Date date;
    private String heureDebut;
    private String heureFin;
    private LieuBean lieu;

    public ActiviteBean(){
        this.date = null;
        this.heureDebut = null;
        this.heureFin = null;
        this.lieu = null;
    }

    public Date getDate() { return this.date; }
    public String getHeureDebut() { return this.heureDebut; }
    public String getHeureFin() { return this.heureFin; }
    public LieuBean getLieu() { return this.lieu; }

    public void setDate(Date date) { this.date = date; }
    public void setHeureDebut(String heureDebut) { this.heureDebut = heureDebut; }
    public void setHeureFin(String heureFin) { this.heureFin = heureFin; }
    public void setLieu(LieuBean lieu) { this.lieu = lieu; }
}
