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

@WebServlet(name = "AlerteServlet")
public class AlerteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserBean current_user = (UserBean) session.getAttribute("current_user");
        SQLConnector sc = new SQLConnector();


        sc.alertePositif(current_user.getLogin());

        //Page de redirection utilisateur/admin
        response.sendRedirect("Bean");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
