<%@ page import="bean.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: Nicolas
  Date: 26/12/2020
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css" />
    <title>Modifier son compte</title>
</head>
<body>

<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <h2 class="active"> Modify account </h2>


        <% UserBean current_user = (UserBean) session.getAttribute("current_user");%>

        <!-- Form -->
        <form action="ModifyAccount" method="post">
            <input type="text" id="login" class="fadeIn second" name="login" placeholder=<% out.print(current_user.getLogin()); %>>
            <input type="text" id="password" class="fadeIn second" name="password" placeholder=<% out.print(current_user.getPassword()); %>>
            <input type="text" id="nom" class="fadeIn third" name="nom" placeholder=<% out.print(current_user.getNom()); %>>
            <input type="text" id="prenom" class="fadeIn third" name="prenom" placeholder=<% out.print(current_user.getPrenom()); %>>
            <br> <label> Date de Naissance </label>
            <input type="date" id="dateNaissance" class="fadeIn third" name="dateNaissance" placeholder=<% out.print(current_user.getDateNaissance()); %>>

            <input type="hidden" id="oldLogin" name="oldLogin" value=<% out.print(current_user.getLogin()); %>>

            <h5> <%
                if(session.getAttribute("msg-err") != null)
                    out.print(session.getAttribute("msg-err"));
            %> </h5>


            <input type="submit" class="fadeIn fourth" value="Modifier mes infos">
        </form>

        <!-- Retour au menu -->
        <div id="formFooter">
            <a class="underlineHover" href=Bean> Retour au menu </a>
        </div>

    </div>
</div>

</body>
</html>
