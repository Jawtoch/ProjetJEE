<%@ page import="bean.ActiviteBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Nicolas
  Date: 30/12/2020
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css" />
    <title>Mes Activites</title>
</head>
<body>

<% List<ActiviteBean> activites = (ArrayList<ActiviteBean>) session.getAttribute("activities"); %>

<div class="box">

    <%
        for (ActiviteBean activite : activites) {
            String lieu = activite.getLieu();
            String date = activite.getDate();
            String heureDebut = activite.getHeureDebut();
            String heureFin = activite.getHeureFin();
            String adresse = activite.getAdresse();
            int id = activite.getId();

            out.write("<div class=\"wrapper fadeInDown\">");
            out.write("<div id=\"formContent\">");

            out.write("<h2 class=\"active\">");
            out.write("Le " + date);
            out.write(" à " + lieu +", " + adresse);
            out.write(" de : " +heureDebut + "  à  " + heureFin);
            out.write("</h2>");

            out.write("<div id=\"formFooter\">");

            out.write("<a class=\"underlineHover\" href=DeleteActivity?id="+id+"> Supprimer </a>");
            out.write("</div>");
            out.write("</div>");
            out.write("</div>");


        }
    %>

    <div class="wrapper fadeInDown">
        <!-- Retour au menu -->
        <div id="formFooter">
            <a class="underlineHover" href=showActivitiesCalendar.jsp> Afficher le calendrier </a>
        </div>
    </div>

    <div class="wrapper fadeInDown">
        <!-- Retour au menu -->
        <div id="formFooter">
            <a class="underlineHover" href=Bean> Retour au menu </a>
        </div>
    </div>





</div>

</body>
</html>
