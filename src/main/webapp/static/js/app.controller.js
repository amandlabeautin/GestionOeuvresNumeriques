angular
  .module('GestionOeuvresNumeriques')
  .controller("rentController", function($scope,$http,$routeParams) {

	$http.get('http://localhost:8080/livre').
	  success(function(data, status, headers, config) {
	  	$scope.listeLivres = data;
	  	$scope.selected = data[0];
	  }).
	  error(function(data, status, headers, config) {
	  });

        
});