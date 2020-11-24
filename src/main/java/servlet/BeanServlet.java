package servlet;

import bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "BeanServlet")
public class BeanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        UserBean current_user = (UserBean) session.getAttribute("current_user");

        if(current_user == null){
            request.getRequestDispatcher("login.html").forward(request, response);
        }
        else{
            request.getRequestDispatcher("logged.jsp").forward(request, response);
        }
    }
}
