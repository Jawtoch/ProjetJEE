<%@ page import="bean.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: Nicolas
  Date: 12/11/2020
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css" />
    <title>Title</title>
</head>

<body>

<div class="box">


    <div class="wrapper fadeInDown">
        <div id="formContent">
            <!-- Tabs Titles -->
            <h2 class="active"> Mon compte </h2>

            <!-- Voir infos compte : redirection vers account.jsp -->
            <div class="formFooter">
                <a class="underlineHover" href=account.jsp> Modifier mes informations </a>
            </div>

            <!-- Voir notifications redirection vers LoadNotificationServlet -->
            <div class="formFooter">
                <a class="underlineHover" href=LoadNotification> Voir mes notifications </a>
            </div>

        </div>
    </div>



    <div class="wrapper fadeInDown">
        <div id="formContent">
            <!-- Tabs Titles -->
            <h2 class="active"> Ajouter une activité </h2>


            <!-- redirection vers activity.jsp -->
            <div class="formFooter">
                <a class="underlineHover" href=activity.jsp> Ajouter une activité </a>
            </div>

        </div>
    </div>


    <div class="wrapper fadeInDown">
        <div id="formContent">
            <!-- Tabs Titles -->
            <h2 class="active"> Ajouter un ami </h2>

            <!-- Friend -->
            <form action="AddFriend" method="post">
                <input type="text" id="username" class="fadeIn second" name="username" placeholder="Friends username">
                <input type="submit" class="fadeIn third" value="Add Friend">
            </form>

            <!-- Afficher Liste amis -->
            <div class="formFooter">
                <a class="underlineHover" href=#> Afficher mes amis </a>
            </div>

        </div>
    </div>


    <div class="wrapper fadeInDown">
        <div id="formContent">
            <!-- Tabs Titles -->
            <h2 class="active"> Alerte Positif </h2>

            <!-- Login Form -->
            <form action="Alerte" method="post">
                <input type="submit" class="fadeIn third" value="Lancer l'alerte">
            </form>

        </div>
    </div>




</div>

</body>

</html>
