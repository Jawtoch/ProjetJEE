package servlet;

import bean.NotificationBean;
import sql.SQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeclineNotifServlet")
public class DeclineNotifServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SQLConnector sc = new SQLConnector();

        String id = request.getParameter( "id" );
        String type = request.getParameter( "type" );

        sc.declineNotification(id, type);

        //Page de redirection utilisateur/admin
        response.sendRedirect("Bean");

    }
}
