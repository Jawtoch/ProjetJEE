package servlet;

import sql.SQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SendFriendRequestServlet")
public class SendFriendRequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String otherUserLogin = request.getParameter("otherUserLogin");

        HttpSession session = request.getSession();
        SQLConnector sc = new SQLConnector();

        if(!login.equals("")) {
            sc.sendFriendRequest(login, otherUserLogin);
        }
        else{
            session.setAttribute("msg-err"," Le nom de l'utilisateur ne doit pas être vide ");
        }

        //Page de redirection utilisateur/admin
        response.sendRedirect("Bean");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Bean");
    }
}
