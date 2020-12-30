<%@ page import="bean.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: Nicolas
  Date: 27/12/2020
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css" />
    <title>Ajouter une activité</title>
</head>
<body>

<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <h2 class="active"> Information sur  l'activité </h2>


        <% UserBean current_user = (UserBean) session.getAttribute("current_user");%>

        <!-- Form -->
        <form action="AddActivity" method="post">
            <input type="text" id="lieu" class="fadeIn second" name="lieu" placeholder="lieu" required>
            <input type="text" id="adresse" class="fadeIn second" name="adresse" placeholder="adresse" required>
            <input type="date" id="date" class="fadeIn third" name="date" placeholder="date" required>
            <input type="time" id="heureDebut" class="fadeIn third" name="heureDebut" placeholder="heureDebut">
            <input type="time" id="heureFin" class="fadeIn third" name="heureFin" placeholder="heureFin">

            <input type="hidden" id="userLogin" name="userLogin" value=<% out.print(current_user.getLogin()); %>>

            <h5> <%
                if(session.getAttribute("msg-err") != null)
                    out.print(session.getAttribute("msg-err"));
            %> </h5>


            <input type="submit" class="fadeIn fourth" value="Ajouter l'activité">
        </form>

        <!-- Retour au menu -->
        <div id="formFooter">
            <a class="underlineHover" href=Bean> Retour au menu </a>
        </div>

    </div>
</div>

</body>
</html>
