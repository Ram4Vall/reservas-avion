function searchForm() {
  this.sForm = $("#FormReserva");
  this.vueloSearch;
  this.vuelosResult;
  this.setUpForm();
}

searchForm.prototype.setUpForm = function() {
  this.vuelosResult = todosVuelos;
  var that = this;
  jQuery.validator.setDefaults({
    debug: true,
    success: "valid"
  });
  $("#maxPrice").on("change", function() {
    $("label").find("span").html(this.value);
  });
  this.sForm.validate();
  //this.setDatePicker();
  this.setAerolineasSelect();

  this.sForm.submit(function() {
    console.log(that.sForm.valid());
    if(that.sForm.valid()){
      that.createSearchObject();
      this.vuelosResult = todosVuelos;
    }
    return false;
  });
}
searchForm.prototype.createSearchObject = function(){
  var that = this;
  this.vueloSearch = {
  "precioMax": this.sForm[0].maxPrice.value,
  "horaIda": this.sForm[0].checkInTime.value,
  //"horaVuelta": this.sForm[0].checkOutTime.value,
  "fechaIda": this.sForm[0].checkin.value,
  //"fechaVuelta": this.sForm[0].checkout.value,
  "codAerolinea": this.sForm[0].company.value,
  "codPuertoSalida": this.sForm[0].origen.value,
  "codPuertoLlegada": this.sForm[0].destino.value
  };
  this.filtrarVuelos();
  //console.log(this.vueloSearch);
  showOffers(that.vuelosResult);
}
searchForm.prototype.filtrarVuelos = function(){
  this.vuelosResult = this.vuelosResult.filter(this.filterFecha);
  this.vuelosResult = this.vuelosResult.filter(this.filterOrigen);
  this.vuelosResult = this.vuelosResult.filter(this.filterDestino);
  this.vuelosResult = this.vuelosResult.filter(this.filterPrecio);
  if(this.vueloSearch.codAerolinea=="empty")
    this.vuelosResult = this.vuelosResult.filter(this.filterAerolinea);
  //
  /*if(this.vueloSearch.horaIda==""){
    this.vuelosResult = this.vuelosResult.filter(this.filterHoraIda);
  }*/
  console.log(this.vuelosResult);
}
searchForm.prototype.filterFecha = function(element){
  return element.fecha==searchFlightForm.vueloSearch.fechaIda;
}
searchForm.prototype.filterOrigen = function(element){
  return element.numVuelo.codAeropuertoSalida.nombre==searchFlightForm.vueloSearch.codPuertoSalida;
}
searchForm.prototype.filterDestino = function(element){
  return element.numVuelo.codAeropuertoLlegada.nombre==searchFlightForm.vueloSearch.codPuertoLlegada;
}
searchForm.prototype.filterPrecio = function(element){
  return element.numVuelo.precio<=searchFlightForm.vueloSearch.precioMax;
}
searchForm.prototype.filterDestino = function(element){
  return element.numVuelo.codAerolinea.codAerolinea==searchFlightForm.vueloSearch.codAerolinea;
}
searchForm.prototype.setAerolineasSelect = function() {
  $.ajax({
    url: "/ReservasRS/webresources/aerolinea",
    type: "GET",
    crossdomain: true,
    dataType: "json",
    success: function(json) {
      console.log(json);
      for (var i = 0; i < json.length; i++) {
        $("#company").append("<option value='" + json[i].codAerolinea + "'>" + json[i].nombre + "</option>");
      }
    }
  });
}
searchForm.prototype.getDate = function(element) {
  var dateFormat = "dd/MM/yy";
  var date;
  try {
    date = $.datepicker.parseDate(dateFormat, element.value);
  } catch (error) {
    date = null;
  }
  return date;
}
searchForm.prototype.setDatePicker = function() {
  var that = this;
  $("#checkIn").datepicker().on("change", function() {
    $("#checkOut").prop("disabled", false);
    $("#checkOut").datepicker("option", "minDate", that.getDate(this));
  });
  $("#checkIn").datepicker('option','dateFormat','dd/mm/yy')
  $("#checkOut").prop("disabled", true)
    .datepicker({
      dateFormat:"dd/MM/yy",
      defaultDate: "+1W",
      showAnim: "slideDown",
      changeMonth: true,
      numberOfMonths: 1
    }).on("change", function() {
      $("#checkIn").datepicker("option", "maxDate", that.getDate(this));
    });
  
  $("checkInTime").timepicker();
  $("checkOutTime").timepicker();
}
searchForm.prototype.comprarVuelo = function(idVuelo){
  var nombre = $("#nombre"+idVuelo).val();
  var apellidos = $("#apellidos"+idVuelo).val();
  var tarjeta = $("#tarjeta"+idVuelo).val();
  var telefono = $("#telefono"+idVuelo).val();
  var precio = this.vuelosResult[idVuelo].numVuelo.precio;
  var reserva = {
    "nombre":nombre,
    "apellidos":apellidos,
    "telefono":telefono,
    "tarjeta":tarjeta,
    "importe":precio,
    "idVuelo":idVuelo
  }
  console.log(reserva);
  var strReserva = JSON.stringify(reserva);
  console.log(strReserva)
  /*$.ajax({
    url: "/ReservasRS/webresources/reserva",
    type: "POST",
    data: reserva,
    crossdomain: true,
    success: function() {
      alert("Envío correcto");
    }
  });*/
  $.post("/ReservasRS/webresources/reserva",strReserva);
}