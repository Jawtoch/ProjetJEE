<%@ page import="bean.UserBean" %><%--
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
    <title>Ajouter un ami</title>
</head>
<body>

<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <h2 class="active"> Ajouter un ami </h2>

        <% UserBean current_user = (UserBean) session.getAttribute("current_user");%>

        <!-- Login Form -->
        <form action="SendFriendRequest" method="post">
            <input type="text" id="login" class="fadeIn second" name="login" placeholder="nom d'utilisateur" required>
            <input type="hidden" id="otherUserLogin" name="otherUserLogin" value=<% out.print(current_user.getLogin()); %>>
            <input type="submit" class="fadeIn fourth" value="Envoyer une demande">
        </form>

        <!-- Retour au menu -->
        <div id="formFooter">
            <a class="underlineHover" href=Bean> Retour au menu </a>
        </div>

    </div>
</div>

</body>
</html>
