package servlet;

import bean.NotificationBean;
import bean.UserBean;
import sql.SQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AcceptNotifServlet")
public class AcceptNotifServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SQLConnector sc = new SQLConnector();

        String id = request.getParameter( "id" );
        String type = request.getParameter( "type" );

        sc.acceptNotification(id, type);

        //Page de redirection utilisateur/admin
        response.sendRedirect("Bean");


    }
}
