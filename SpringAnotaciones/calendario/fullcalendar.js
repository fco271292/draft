$.noConflict();
jQuery(document).ready(function ($) {
	
	$('#calendar').fullCalendar({
        header: { center: 'month,agendaWeek' },
        weekends: false,
        minTime: "07:00:00",
        maxTime: "21:00:00",
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
        events: [
        	/*{
        		title: "Evento_Default \n Descripcion...",
        		start:"2017-07-14T12:00:00",
        		end:"2017-07-07T13:15:00",
        		editable: false,
        		backgroundColor: "#000000",
        		borderColor: "#FFFFFF",
        		textColor: "#FFFFFF"
        	}*/
        ]
        

    

    })

    var buttonSave =  document.getElementById("buttonSave")
    buttonSave.onclick = function () {
        
        var formEvent = readData()

        $.ajax(
            {
                url: "",
                method: "GET",
                beforeSend: function (xhr) {
                    
                },
                contentType: "text/plain",
                data: {},
                success: function (data,textStatus,jqXHR) {
                    //console.log("Exito... "+JSON.stringify(data))
                    $("#calendar").fullCalendar('renderEvent',
                    {
                        title: formEvent.descriptionEvent,
                        start: formEvent.startEvent,
                        end: formEvent.endEvent,
                        editable: false,
                        backgroundColor: "#000000",
                        borderColor: "#FFFFFF",
                        textColor: "#FFFFFF"
                    },
                    true)

                },
                error: function(error) {
                    console.log("Error... "+JSON.stringify(error))
                },
                dataType: "text"

            }
        )
    }
    

})


function readData() {

    var startEvent = document.getElementById("startEvent")
    var endEvent = document.getElementById("endEvent")
    var descriptionEvent = document.getElementById("descriptionEvent")
    
    return {
        startEvent: parseDate(startEvent.value), 
        endEvent: parseDate(endEvent.value),
        descriptionEvent:descriptionEvent.value
    }        

}

function parseDate(dateString) {

    var date = null
    if(dateString.length > 18){
        var day = dateString.substr(0,2)
        var month = dateString.substr(3,2)
        var year = dateString.substr(6,4)
        var hour = dateString.substr(11,2)
        var minute = dateString.substr(14,2)
        var second = dateString.substr(17,2)
        date = new Date(`${year}-${month}-${day}T${hour}:${minute}:${second}`)
        
    }
    return date ? date : new Date()

}