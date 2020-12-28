package bean;

public class NotificationBean {

    private int id;
    private String notification;
    private String type;

    public NotificationBean(){
        this.notification = null;
        this.type = null;
    }

    public String getNotification(){return this.notification;}
    public int getId(){ return this.id; }
    public String getType() {return type; }

    public void setNotification(String notification){this.notification = notification;}
    public void setId(int id){this.id = id;}
    public void setType(String type){this.type = type;}

}
