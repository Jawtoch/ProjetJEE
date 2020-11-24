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
    <title>Title</title>
</head>
<body>


<div class="container">
    <label>Vous êtes connecté</label>


    </br>
    <div class="col-md-12">

        <% UserBean current_user = (UserBean) session.getAttribute("current_user"); %>


    </div>


</div>



</body>
</html>
