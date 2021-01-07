package servlet;

import sql.SQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddActivityServlet")
public class AddActivityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        SQLConnector sc = new SQLConnector();

        String lieu = request.getParameter("lieu");
        String adresse = request.getParameter("adresse");

        if(adresse == null){
            adresse = (String) session.getAttribute("adresse");
            session.setAttribute("adresse",null);
        }


        String date = request.getParameter("date");
        String heureDebut = request.getParameter("heureDebut");
        String heureFin = request.getParameter("heureFin");
        String userLogin = request.getParameter("userLogin");




        if(!lieu.equals("") && !date.equals("")) {
            sc.addActivity(lieu, adresse, date, heureDebut, heureFin, userLogin);
        }
        else{
            session.setAttribute("msg-err"," Lieu/Date ne doivent pas être vide");
        }

        //Page de redirection utilisateur/admin
        response.sendRedirect("Bean");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
