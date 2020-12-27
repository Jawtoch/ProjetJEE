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
import java.util.ArrayList;

@WebServlet(name = "LoadNotificationServlet")
public class LoadNotificationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        SQLConnector sc = new SQLConnector();

        UserBean current_user = (UserBean) session.getAttribute("current_user");
        int idUser = current_user.getId();

        //ArrayList<String> notifications = new ArrayList<>();
        session.setAttribute("notifications",sc.loadNotifications(idUser));

        //Page de redirection utilisateur/admin
        response.sendRedirect("notification.jsp");

    }
}
