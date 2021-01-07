<%--
  Created by IntelliJ IDEA.
  User: Nicolas
  Date: 07/01/2021
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css" />
    <title>Upload Image</title>

</head>
<body>

<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <h2 class="active"> Choisir une image </h2>

        <!-- Form -->
        <form action="UploadImage" enctype="multipart/form-data" method="post">
            <input type="file" id="image" name ="image"/> <br/>
            <input type="submit" value="Upload" /> <br/>
        </form>



        <!-- Retour au menu -->
        <div id="formFooter">
            <a class="underlineHover" href=Bean> Retour au menu </a>
        </div>

    </div>
</div>


</body>
</html>