<%--
  Created by IntelliJ IDEA.
  User: Nicolas
  Date: 04/01/2021
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css" />
    <title>Supprimer un utilisateur</title>
</head>
<body>

<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <h2 class="active"> Supprimer un utilisateur </h2>

        <!-- Form -->
        <form action="DeleteUser" method="post">
            <input type="text" id="login" class="fadeIn second" name="login" placeholder="login" required>
            <input type="submit" class="fadeIn third" value="Supprimer">
        </form>

        <!-- Back Menu -->
        <div id="formFooter">
            <a class="underlineHover" href=Bean> Retour au menu </a>
        </div>

    </div>
</div>

</body>
</html>
