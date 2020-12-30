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

@WebServlet(name = "LoadActivitiesServlet")
public class LoadActivitiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        SQLConnector sc = new SQLConnector();

        UserBean current_user = (UserBean) session.getAttribute("current_user");
        String userLogin = current_user.getLogin();

        session.setAttribute("activities",sc.loadActivites(userLogin));

        //Page de redirection showFriends.jsp
        response.sendRedirect("showActivities.jsp");


    }
}
