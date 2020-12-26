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
            <h2 class="active"> Modifier mon compte </h2>

            <!-- Afficher Liste amis -->
            <div class="formFooter">
                <a class="underlineHover" href=account.jsp> Voir mes informations </a>
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
            <h2 class="active"> Ajouter une activité </h2>

            <!-- Login Form -->
            <form action="AddActivity" method="post">
                <input type="text" id="lieu" class="fadeIn second" name="lieu" placeholder="Lieu">
                <input type="submit" class="fadeIn third" value="Add activity">
            </form>

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
