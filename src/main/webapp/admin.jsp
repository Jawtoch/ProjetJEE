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
    <label>Vous êtes connecté en admin</label>


    </br>
    <div class="col-md-12">



        <% UserBean current_user = (UserBean) session.getAttribute("current_user"); %>

        <%
            if(current_user.getRang().trim().equals("utilisateur")) {
                request.getRequestDispatcher( "logged.jsp" ).forward( request, response );
            }
        %>

        <h3> Login est : <% out.print(current_user.getLogin()); %> </h3>
        <h3> Password est : <% out.print(current_user.getPassword()); %> </h3>
        <h3> Prenom est : <% out.print(current_user.getPrenom()); %> </h3>
        <h3> Nom est : <% out.print(current_user.getNom()); %> </h3>
        <h3> dateNaissance est : <% out.print(current_user.getDateNaissance()); %> </h3>



    </div>


</div>



</body>
</html>
