package servlet;

import sql.SQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteActivityServlet")
public class DeleteActivityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        SQLConnector sc = new SQLConnector();

        String id = request.getParameter( "id" );

        sc.deleteActivity(id);

        //Page de redirection
        response.sendRedirect("LoadActivities");

    }
}
