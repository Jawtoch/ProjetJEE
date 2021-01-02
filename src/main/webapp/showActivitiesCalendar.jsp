<%@ page import="bean.ActiviteBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calendrier des activites</title>
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/simple-calendar.css">
    <link rel="stylesheet" href="css/demo.css">
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<h1 class="title">Calendrier des activites</h1>
<div id="container" class="calendar-container"></div>

<script src="https://code.jquery.com/jquery-2.2.4.min.js"
        integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
        crossorigin="anonymous"></script>
<script src="js/jquery.simple-calendar.js"></script>

<% List<ActiviteBean> activites = (ArrayList<ActiviteBean>) session.getAttribute("activities"); %>

<div class="wrapper fadeInDown">
    <!-- Retour au menu -->
    <div id="formFooter">
        <a class="underlineHover" href=Bean> Retour au menu </a>
    </div>
</div>

<script>
    $(document).ready(function () {
        $("#container").simpleCalendar({
            fixedStartDay: 0, // begin weeks by sunday
            disableEmptyDetails: true,
            events: [

                <%
                    for (ActiviteBean activite : activites) {
                        String lieu = activite.getLieu();
                        String date = activite.getDate();
                        String adresse = activite.getAdresse();
                        lieu = lieu + ", " + adresse;

                        out.write("{");
                        out.write("startDate: new Date('"+ date +"'),");
                        out.write("endDate: new Date('"+ date +"'),");
                        out.write("summary: '"+ lieu +"'");
                        out.write("},");

                    }
                %>
                // startDate: new Date(new Date('"+ date +"').setHours('"+ h +"'),
                // generate last event to stop
                {
                    endDate: new Date("2000-1-1").toDateString(),
                }
            ],

        });
    });
</script>




</body>
</html>