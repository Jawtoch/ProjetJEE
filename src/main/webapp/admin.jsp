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
    <title>Menu admin</title>
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

            <!-- Se déconnecter redirection vers DisconnectServlet -->
            <div class="formFooter">
                <a class="underlineHover" href=Disconnect> Se déconnecter </a>
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

            <!-- redirection vers LoadActivities -->
            <div class="formFooter">
                <a class="underlineHover" href=LoadActivities> Voir mes activités </a>
            </div>

        </div>
    </div>


    <div class="wrapper fadeInDown">
        <div id="formContent">
            <!-- Tabs Titles -->
            <h2 class="active"> Mes amis </h2>

            <!-- Ajouter un ami redirection vers addFriend.jsp -->
            <div class="formFooter">
                <a class="underlineHover" href=addFriend.jsp> Ajouter un ami </a>
            </div>

            <!-- Afficher Liste amis redirection vers showFriends.jsp -->
            <div class="formFooter">
                <a class="underlineHover" href=LoadFriends> Afficher mes amis </a>
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
