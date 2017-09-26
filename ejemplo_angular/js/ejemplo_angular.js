console.log("Cargo script angular");
var app = angular.module("ModuloAngular", []);
app.controller('ControladorFecha', ['$scope', function($scope){
	$scope.fecha = new Date().toJSON();
	$scope.saludar = function () {
		alert("Hola "+$scope.nombre)
	};
}]);

app.controller('ValidacionSimple', ['$scope', function($scope){
	$scope.longitud_minima = false
	$scope.longitud_cadena_minima = 3
	$scope.$watch('password', function(newValue, oldValue, scope) {
		if (newValue != null && newValue.length < $scope.longitud_cadena_minima){
			$scope.longitud_minima = true
		}else{
			$scope.longitud_minima = false
		}
	});
}])

app.controller('ValidacionMultiple', ['$scope', function($scope){
	$scope.cambio = function () {
		$scope.valorCheckbox = $scope.libro
	}
	$scope.$watchGroup(['libro','revista','valorSiNo'], function(newValue, oldValue, scope) {
		//console.log("Valores: "+newValue)
		for (var i = 0; i < newValue.length; i++) {
			//console.log("Valor:.. "+ newValue[i])
		}
	});
}])

app.controller('Iteracion', function($scope){
	var self = this
	self.msn = "Abecedario"
	self.lista  = []
	for (var numero = 97; numero < 123; numero++ ) {
		self.lista.push(String.fromCharCode(numero))
	}
	self.persona = {
		persona1: {'nombreCompleto': 'Pedro Picapidra','edad': 20},
		persona2: {'nombreCompleto': 'Pablo Marmol', 'edad': 22}
	}
	self.mostrarInformacion = function (propiedades) {
		alert("Valor actual "+propiedades.nombreCompleto)
	}
})

app.controller('Formulario', ['$scope', function($scope){
	$scope.minimo = 5;
	$scope.enviar = function(argument) {

		console.log("Ingreso: "+$scope.nombreFormulario)
	};
}])

app.service('Servicio', function($http){
	var self = this
	self.listaPaises = []
	self.fechaServicio = function () {
		return new Date()
	}
	self.obtenerPaises = function () {
		return $http({
			method: 'GET',
			url: "http://services.groupkt.com/country/get/all"
		})		
	}
})

app.controller('EjecutarServicio', ['$scope','Servicio', function($scope,Servicio){
	$scope.fecha = Servicio.fechaServicio().toJSON()
	console.log("Fecha del servicio:.. "+$scope.fecha)
	$scope.paises = null
	Servicio.obtenerPaises()
	.then(function success(response) {
		var paises = response.data.RestResponse.result
		$scope.paises = paises
	})
	,(function error(response) {
		console.log("Error :( "+response)
	})

}])