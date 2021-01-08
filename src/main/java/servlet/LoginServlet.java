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

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        SQLConnector sc = new SQLConnector();

        if(!login.equals("") && !password.equals("")){

            UserBean current_user = sc.getUser(login, password);
            session.setAttribute("current_user", current_user);
            request.setAttribute("current_user", current_user);

        }

        //Page de redirection utilisateur/admin
        response.sendRedirect("Bean");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Bean");
    }
}
