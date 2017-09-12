console.log("Cargo script angular");
var app = angular.module("ModuloAngular", []);
app.controller('ControladorFecha', ['$scope', function($scope){
	$scope.fecha = new Date().toJSON();
	$scope.saludar = function () {
		alert("Hola "+$scope.nombre)
	};
}]);
