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
