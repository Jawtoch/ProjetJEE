<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <!-- Nous chargeons les fichiers CDN de Leaflet. Le CSS AVANT le JS -->
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.1/dist/leaflet.css" integrity="sha512-Rksm5RenBEKSKFjgI3a41vrjkw4EVPlJ3+OiI65vTjIdo9brlAacEuKOiQ5OFh7cOI1bkDwLqdLw3Zg0cRJAAQ==" crossorigin="" />
    <link rel="stylesheet" type="text/css" href="https://unpkg.com/leaflet.markercluster@1.3.0/dist/MarkerCluster.css" />
    <link rel="stylesheet" type="text/css" href="https://unpkg.com/leaflet.markercluster@1.3.0/dist/MarkerCluster.Default.css" />
    <link rel="stylesheet" href="css/style.css" />
    <style type="text/css">
        #map{ /* la carte DOIT avoir une hauteur sinon elle n'apparaît pas */
            height:400px;
        }
    </style>
    <title>Carte</title>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <h2 class="active"> Carte </h2>

        <div id="map">
            <!-- Ici s'affichera la carte -->
        </div>

        <!-- Menu  -->
        <div id="formFooter">
            <a class="underlineHover" href=Bean> Retour au menu</a>
        </div>

    </div>
</div>


<!-- Fichiers Javascript -->
<script src="https://unpkg.com/leaflet@1.3.1/dist/leaflet.js" integrity="sha512-/Nsx9X4HebavoBvEBuyp3I7od5tA0UzAxs+j83KgC8PU0kgB4XiK4Lfe4y4cgBtaRJQEIFCW+oC506aPT2L1zw==" crossorigin=""></script>
<script type='text/javascript' src='https://unpkg.com/leaflet.markercluster@1.3.0/dist/leaflet.markercluster.js'></script>

<script type="text/javascript">
    // On initialise la latitude et la longitude de Paris (centre de la carte)
    var macarte = null;
    var lat = 48.7333;
    var lon = 6.1667;

    // Initialisation de la carte
    function initMap() {

        // Insere la carte dans l'élément HTML qui a l'ID map
        macarte = L.map('map').setView([lat, lon], 11);

        //Serveur de cartes
        L.tileLayer('https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png', {
            //Lien vers la source des données
            attribution: 'données © <a href="//osm.org/copyright">OpenStreetMap</a>/ODbL - rendu <a href="//openstreetmap.fr">OSM France</a>',
            minZoom: 1,
            maxZoom: 20
        }).addTo(macarte);

        macarte.on('click', onMapClick);

    }
    window.onload = function(){
        //initialisation
        initMap();
    };

    function onMapClick(e) {
        let str = e.latlng.toString();
        let str2 = str.substr(17);
        let regexp = /[0-9]+.[0-9][0-9][0-9]/;

        document.location.href="Map?adresse="+str.match(regexp)+","+str2.match(regexp);
    }



</script>
</body>
</html>