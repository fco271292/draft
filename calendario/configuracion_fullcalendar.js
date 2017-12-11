/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    console.log("Inicio fullcalendar");
    var re = new RegExp(/^.*\//);
    var urlBase =  re.exec(window.location.href).toString();
    $('#calendar').fullCalendar({
        header: { 
            left:'',
            center: 'basicWeek,agendaWeek',
            right: ''
        },
        themeSystem: "bootstrap3",
        height: "auto",
        weekends: false,
        minTime: "07:00:00",
        maxTime: "23:00:00",
        slotDuration: "00:30:00",
        allDaySlot: false,
        columnFormat: "dddd",
        titleFormat: "dddd",
        defaultView: "agendaWeek",
        views: {
        	agendaWeek: {
        		titleFormat: "MMMM-YYYY"
        	}
        },
        events: {
            /*url: urlBase+"Eventos",
            color: 'yellow',   
            textColor: 'black' */
        }
                //[
        	/*{
        		title: "Evento_Default \n Descripcion...",
        		start:"2017-07-14T12:00:00",
        		end:"2017-07-07T13:15:00",
        		editable: false,
        		backgroundColor: "#000000",
        		borderColor: "#FFFFFF",
        		textColor: "#FFFFFF"
        	}*/
        //]
    });
    recuperarInformacionEventos();
});

function recuperarInformacionEventos() {
        var urlCompleta = window.location;
        var re = new RegExp(/^.*\//);
        var urlBase =  re.exec(window.location.href).toString();
        
        $.ajax(
            {
                url: urlBase+"Eventos",
                method: "GET",
                beforeSend: function (xhr) {
                    
                },
                contentType: "text/plain",
                data: {},
                success: function (data,textStatus,jqXHR) {
                    console.log("Exito... ");
                    console.log(data);
                    for(var indice = 0; indice < data.length; indice++ ){
                        $("#calendar").fullCalendar('renderEvent',
                            {
                                title: data[indice].materia,
                                start: convertirFecha(data[indice].dia,data[indice].horaEntrada),
                                end: convertirFecha(data[indice].dia,data[indice].horaSalida),
                                editable: false,
                                backgroundColor: "#000000",
                                borderColor: "#FFFFFF",
                                textColor: "#FFFFFF"
                            },true);
                    
                    }
                },
                error: function(error) {
                    console.log("Error... "+JSON.stringify(error));
                },
                dataType: "json"

            }
        );
}

function convertirFecha(diaSemana,hora) {
    var fechaActual = moment();
    var fechaInicioSemana = fechaActual.clone().startOf('week');
    var fechaFinSemana = fechaActual.clone().endOf('week');
    var semanaActual = [];
    var fecha = null;
   	
    for (var indice = 0; indice < 5; indice++) {
        //Llena el arreglo de la semanaactual, sumando 1 dia hasta el 5, lo que representa de Lunes - Viernes
        semanaActual.push(moment(fechaInicioSemana).add(indice, 'days').format("DD-MM-YYYY HH:mm:ss,dddd"));
    };
    
    for (var i = 0; i < semanaActual.length; i++) {
        //Se hace el remplazo del caracter acentuado
        var diaSemanaAjusteLetra = semanaActual[i].replace(/é/gi,'e')
        if ( diaSemanaAjusteLetra.lastIndexOf(diaSemana.toString().toLowerCase()) !== -1){
            //Recupera solo la fecha en formato DD-MM-YYYY
            //Con la hora que se ingresa se anexa con el formato HH:mm:ss
            var fechaString = semanaActual[i].substr(0,11)+hora;
            fecha = moment(fechaString,"DD-MM-YYYY HH:mm:ss");
        }
    };
    return fecha;
}