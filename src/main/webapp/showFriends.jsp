<%@ page import="bean.UserBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Nicolas
  Date: 28/12/2020
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css" />
    <title>Mes amis</title>
</head>
<body>

<% List<UserBean> friends = (ArrayList<UserBean>) session.getAttribute("friends"); %>

<div class="box">

    <%
        for (UserBean user : friends) {
            String login = user.getLogin();

            out.write("<div class=\"wrapper fadeInDown\">");
            out.write("<div id=\"formContent\">");

            out.write("<h2 class=\"active\">");
            out.write(user.getLogin());
            out.write("</h2>");

            out.write("<div id=\"formFooter\">");

            out.write("<a class=\"underlineHover\" href=DeleteFriend?login="+login+"> Supprimer </a>");


            out.write("</div>");

            out.write("</div>");
            out.write("</div>");


        }
    %>

    <div class="wrapper fadeInDown">
        <!-- Retour au menu -->
        <div id="formFooter">
            <a class="underlineHover" href=Bean> Retour au menu </a>
        </div>
    </div>





</div>

</body>
</html>
