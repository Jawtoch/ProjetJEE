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

@WebServlet(name = "DeleteFriendServlet")
public class DeleteFriendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserBean current_user = (UserBean) session.getAttribute("current_user");
        SQLConnector sc = new SQLConnector();

        String userLogin1 = request.getParameter( "login" );
        String userLogin2 = current_user.getLogin();

        sc.deleteFriend(userLogin1, userLogin2);

        //Page de redirection utilisateur/admin
        response.sendRedirect("LoadFriends");

    }
}
