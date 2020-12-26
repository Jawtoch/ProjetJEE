package servlet;

import sql.SQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String dateNaissance = request.getParameter("dateNaissance");

        HttpSession session = request.getSession();
        SQLConnector sc = new SQLConnector();

        if(!login.equals("") && !password.equals("")) {
            sc.createUser(login, password, nom, prenom, dateNaissance);
        }
        else {

            session.setAttribute("msg-err"," Login/Password ne doivent pas être vide");

            session.setAttribute("current_user",null);
            request.setAttribute("current_user",null);
        }

        //Page de redirection utilisateur/admin
        response.sendRedirect("/Bean");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/Bean");
    }
}
