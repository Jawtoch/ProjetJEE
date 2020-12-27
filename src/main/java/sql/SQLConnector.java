package sql;


import bean.UserBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLConnector {

    public SQLConnector(){};

    public UserBean getUser(String login, String password){

        UserBean user = null;

        String rqString = "Select * from User where login='"+login+"' and password='"+password+"';";
        ResultSet res = doRequest(rqString);
        int nbUser = 0;

        try {
            while(res.next()) {
                if(nbUser==0) {
                    user = new UserBean();
                    user.setLogin(res.getString("login"));
                    user.setPassword(res.getString("password"));
                    user.setNom(res.getString("nom"));
                    user.setPrenom(res.getString("prenom"));
                    user.setDateNaissance(res.getDate("dateNaissance"));
                    user.setRang(res.getString("rang"));
                    user.setId(res.getInt("id"));
                }
                else {
                    nbUser++;
                    System.out.println("Plus d'un utilisateur ayant le meme login");
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean isUserExists(String login){
        String rqString = "Select * from User where login='"+login+"';";
        ResultSet res = doRequest(rqString);
        int nbUser = 0;
        try {
            while(res.next()) {
                nbUser++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return nbUser > 0;
    }


    public void createUser(String login, String password, String nom, String prenom, String dateNaissance) {
        //Créer un utilisateur seulement s'il n'existe pas déjà
        if(! isUserExists(login)){
            Connection connection = connect();

            try {
                Statement stmt = connection.createStatement();
                String rqString = "INSERT INTO user (login, password, nom, prenom, dateNaissance, rang) VALUES ('"+login+"','"+password+"','"+nom+"','"+prenom+"','"+dateNaissance+"','utilisateur');";
                stmt.executeUpdate(rqString);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void modifyUser(String login, String password, String nom, String prenom, String dateNaissance, String oldLogin) {

        Connection connection = connect();
        try {
            Statement stmt = connection.createStatement();
            String rqString = "UPDATE user SET login='"+login+"', password ='"+password+"', nom ='"+nom+"', prenom ='"+prenom+"', dateNaissance ='"+dateNaissance+"' WHERE login = '"+oldLogin+"';";
            stmt.executeUpdate(rqString);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addActivity(String lieu, String adresse, String dateActivity, String heureDebut, String heureFin, String idUser) {
        Connection connection = connect();
        try {
            Statement stmt = connection.createStatement();
            String rqString = "INSERT INTO activity (lieu, adresse, dateActivity, heureDebut, heureFin, idUser) VALUES ('"+lieu+"','"+adresse+"','"+dateActivity+"','"+heureDebut+"','"+heureFin+"','"+idUser+"');";
            stmt.executeUpdate(rqString);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<String> loadNotifications(int idUser) {
        List<String> notifications = new ArrayList<>();

        Connection connection = connect();
        try {
            Statement stmt = connection.createStatement();
            String rqString = "SELECT * FROM notification WHERE idUser = '"+idUser+"';";
            ResultSet res = doRequest(rqString);
            try {
                while(res.next()) {
                        notifications.add("L'utilisateur " + res.getString("loginUserCovid") + " a été testé positif au Covid-19, vous l'avez peut-être rencontré le "
                                + res.getString("date") +" à " + res.getString("lieu") );
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
                    }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return notifications;
    }


    private ResultSet doRequest(String rqString) {
        ResultSet result = null;
        Connection connection = connect();

        try {
            Statement stmt = connection.createStatement();
            result = stmt.executeQuery(rqString);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }



    public Connection connect(){

        Connection connection = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println("impossible de charger le pilote jdbc");
        }


        try{
            String DBurl = "jdbc:mysql://localhost:3306/base_projet_jee?useSSL=false&serverTimezone=UTC";
            connection = DriverManager.getConnection(DBurl, "root", "");
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return connection;
    }


}
