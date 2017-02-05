/* GLOBALS SCOPE*/

var searchFlightForm;



$("document").ready(function() {
  searchFlightForm = new searchForm();

  loadData();
});

function loadData() {
  /*var connection = new XMLHttpRequest();
  connection.open("GET", "webresources/vuelogenerico", true);
  connection.setRequestHeader("Content-type", "application/json; charset=utf-8");
  connection.onreadystatechange = function() {
    if (connection.readyState == 4 && connection.status == 200) {
      console.log(JSON.parse(connection.responseText));
    }
  };
  connection.send(null);*/

  $.ajax({
    url: "/ReservasRS/webresources/vuelogenerico",
    type: "GET",
    crossdomain: true,
    dataType: "json",
    success: function(json) {
      //console.log(json);
      showGenericOffers(json);
    }
  });
}

function showOffers(arrayVuelos) {
  var thisTable = $("#offers");
  for (var i = 0; i < arrayVuelos.length; i++) {
    var row = document.createElement("tr");
    $(row).append("<td>" + arrayVuelos[i].codAerolinea.nombre + "</td><td>" +
      arrayVuelos[i].codAeropuertoSalida.nombre + "-" + arrayVuelos[i].codAeropuertoLlegada.nombre + "</td><td>" +
      arrayVuelos[i].horaSalida + "-" + arrayVuelos[i].horaLlegada + "</td><td>" +
      arrayVuelos[i].precio + "€</td><th class='reservarTH'>Reservar</th>");
    thisTable.append(row);
    rowReservar = document.createElement("tr");
    $(rowReservar).append("<td colspan='5' class='divReserva'><input type='text' /></td>");
    thisTable.append(rowReservar);
  }
  $(".reservarTH").click(function(){
    $(".reservarTR").toggle();
  });
}

function showGenericOffers(arrayVuelos) {
  var thisTable = $("#genericOffers");
  for (var i = 0; i < arrayVuelos.length; i++) {
    var row = document.createElement("tr");
    $(row).append("<td>" + arrayVuelos[i].codAerolinea.nombre + "</td><td>" +
      arrayVuelos[i].codAeropuertoSalida.nombre + "-" + arrayVuelos[i].codAeropuertoLlegada.nombre + "</td><td>" +
      arrayVuelos[i].horaSalida + "-" + arrayVuelos[i].horaLlegada + "</td><td>" +
      arrayVuelos[i].precio + "€</td>");
    thisTable.append(row);
  }
}