function searchForm() {
  this.sForm = $("#FormReserva");


  this.setUpForm();
}

searchForm.prototype.setUpForm = function() {
  var that = this;
  jQuery.validator.setDefaults({
    debug: true,
    success: "valid"
  });
  this.sForm.validate();
  this.setDatePicker();
  this.setAerolineasSelect();

  this.sForm.submit(function() {
    console.log(that.sForm.valid());
    if(that.sForm.valid()){
      that.createSearchObject();
    }
    return false;
  });
}
searchForm.prototype.createSearchObject = function(){
  var vueloSearch = {
  "precioMax": this.sForm[0].maxPrice.value,
  "horaIda": this.sForm[0].checkInTime.value,
  "horaVuelta": this.sForm[0].checkOutTime.value,
  "fechaIda": this.sForm[0].checkin.value,
  "fechaVuelta": this.sForm[0].checkout.value,
  "codAerolinea": this.sForm[0].company.value,
  "codPuertoSalida": this.sForm[0].origen.value,
  "codPuertoLlegada": this.sForm[0].destino.value
  };
  console.log(vueloSearch);
  $.ajax({
    url: "/ReservasRS/webresources/vuelogenerico",
    type: "GET",
    crossdomain: true,
    dataType: "json",
    success: function(json){
            console.log(json);
            showOffers(json);
    }
  });
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
  var dateFormat = "mm/dd/yy";
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
  $("#checkIn").datepicker({
    minDate: -20,
    maxDate: "+1M +10D"
  }).on("change", function() {
    $("#checkOut").prop("disabled", false);
    $("#checkOut").datepicker("option", "minDate", that.getDate(this));
  });
  $("#checkOut").prop("disabled", true)
    .datepicker({
      defaultDate: "+1W",
      showAnim: "slideDown",
      changeMonth: true,
      numberOfMonths: 1
    }).on("change", function() {
      $("#checkIn").datepicker("option", "maxDate", that.getDate(this));
    });
  $("#maxPrice").on("change", function() {
    $("label").find("span").html(this.value);
  });
  $("checkInTime").timepicker();
  $("checkOutTime").timepicker();
}