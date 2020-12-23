package sql;


import bean.UserBean;

import java.sql.*;

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
                }
                else {
                    nbUser++;
                    System.out.println("Plus d'un utilisateur ayant le meme login ?");
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }


    public void createUser(String login, String password, String nom, String prenom, String dateNaissance) {

        Connection connection = connect();

        try {
            Statement stmt = connection.createStatement();
            String rqString = "INSERT INTO user (login, password, nom, prenom, dateNaissance) VALUES ('"+login+"','"+password+"','"+nom+"','"+prenom+"','"+dateNaissance+"');";
            stmt.executeUpdate(rqString);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private ResultSet doRequest(String rqString) {
        ResultSet result = null;
        Connection connection = connect();

        try {
            Statement stmt = connection.createStatement();
            result = stmt.executeQuery(rqString);
        }
        catch (SQLException e){
            System.out.println("AAAAAAAAAAAAAAAAAAH");
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
