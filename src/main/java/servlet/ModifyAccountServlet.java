package servlet;

import bean.UserBean;
import sql.SQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ModifyAccountServlet")
public class ModifyAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String dateNaissance = request.getParameter("dateNaissance");
        String oldLogin = request.getParameter("oldLogin");


        HttpSession session = request.getSession();
        SQLConnector sc = new SQLConnector();

        if(!login.equals("") && !password.equals("")) {

            //Vérifier que le login n'existe pas déjà
            //S'il n'a pas changé
            if(login.equals(oldLogin)){
                sc.modifyUser(login, password, nom, prenom, dateNaissance, login);

                UserBean current_user = sc.getUser(login, password);
                session.setAttribute("current_user", current_user);
                request.setAttribute("current_user", current_user);
            }
            //S'il a changé
            else{
                if(sc.isUserExists(login)){     //S'il existe déjà
                    session.setAttribute("msg-err","Ce login est déjà utilisé");
                }
                else{
                    sc.modifyUser(login, password, nom, prenom, dateNaissance, oldLogin);

                    UserBean current_user = sc.getUser(login, password);
                    session.setAttribute("current_user", current_user);
                    request.setAttribute("current_user", current_user);
                }
            }



        }
        else {
            session.setAttribute("msg-err"," Login/Password ne doivent pas être vide");
        }

        //Redirect
        response.sendRedirect("account.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
