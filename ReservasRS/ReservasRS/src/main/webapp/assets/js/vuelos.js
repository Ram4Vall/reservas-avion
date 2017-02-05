/* GLOBALS SCOPE*/

var searchFlightForm;
var todosVuelos;


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
    url: "/ReservasRS/webresources/vuelo",
    type: "GET",
    crossdomain: true,
    dataType: "json",
    success: function(json) {
      console.log(json);
      todosVuelos = json;
      searchFlightForm.vuelosResult = todosVuelos;
      showGenericOffers();
    }
  });
}

function showOffers(arrayVuelos) {
  var thisTable = $("#offers");
  for (var i = 0; i < arrayVuelos.length; i++) {
    var row = document.createElement("tr");
    $(row).append("<td>" + arrayVuelos[i].numVuelo.codAerolinea.nombre + "</td><td>" +
      arrayVuelos[i].numVuelo.codAeropuertoSalida.nombre + "-" + arrayVuelos[i].numVuelo.codAeropuertoLlegada.nombre + "</td><td>" +
      arrayVuelos[i].numVuelo.horaSalida + "-" + arrayVuelos[i].numVuelo.horaLlegada + "</td><td>" +
      arrayVuelos[i].numVuelo.precio + "€</td><th><button class='reservarButton'>Reservar</button></th>");
    thisTable.append(row);
    var idVuelo = arrayVuelos[i].idVuelo;
    rowReservar = document.createElement("tr");
    $(rowReservar).append("<td><input type='text' placeholder='Nombre' id='nombre"+idVuelo+"' /></td><td><input type='text' placeholder='Apellidos' id='apellidos"+idVuelo+"' /></td>"+
      "<td><input type='text' placeholder='Telefono' id='telefono"+idVuelo+"' /></td><td><input type='text' placeholder='Tarjeta' id='tarjeta"+idVuelo+"' /></td> "+
      "<td><button onclick='searchFlightForm.comprarVuelo("+idVuelo+","+arrayVuelos[i].numVuelo.precio+")'>Comprar</button></td>");
    $(rowReservar).addClass("reservarTR");
    thisTable.append(rowReservar);
  }
  $(".reservarButton").click(function(){
    $(".reservarTR").slideUp();
    $(this).parent().parent().next().toggle();
  });
}

function showGenericOffers() {
  var thisTable = $("#genericOffers");
  for (var i = 0; i < todosVuelos.length; i++) {
    var row = document.createElement("tr");
    $(row).append("<td>" + todosVuelos[i].numVuelo.codAerolinea.nombre + "</td><td>" +
      todosVuelos[i].numVuelo.codAeropuertoSalida.nombre + "-" + todosVuelos[i].numVuelo.codAeropuertoLlegada.nombre + "</td><td>" +
      todosVuelos[i].numVuelo.horaSalida + "-" + todosVuelos[i].numVuelo.horaLlegada + "</td><td>" +
      todosVuelos[i].numVuelo.precio + "€</td>");
    thisTable.append(row);
  }
}

function enviarComentario(){
  $("#commentForm").html("<h1>Gracias por su comentario</h1>");
}