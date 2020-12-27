<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Nicolas
  Date: 27/12/2020
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css" />
    <title>Mes notifications</title>
</head>
<body>

<% List<String> notifications = (ArrayList<String>) session.getAttribute("notifications"); %>

<div class="box">

    <%
       for(String notif : notifications){

           out.write("<div class=\"wrapper fadeInDown\">");
           out.write("<div id=\"formContent\">");
           out.write("<h2 class=\"active\">");
           out.write(notif);
           out.write("</h2>");
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
