'use strict';

var rentControllers = angular.module('rentControllers', []);


rentControllers.controller("rentController", function($scope,$http,$routeParams) {
	$http.get('http://localhost:8080/livre').
	  then(function(response) {
	  	$scope.listeLivres = response.data;
	  	$scope.selected = response.data[0];
	  });
	
	$scope.choisirLivre = function(selected) {
		
		$http({
		    method: 'POST',
		    url: 'http://localhost:8080/livre',
		    data: selected,
		    headers: {'Content-Type': 'application/json'}
		});
	};     
});

rentControllers.controller("modifierController", function($scope,$http,$routeParams) {
	$http.get('http://localhost:8080/livre/50 nuances de sombres').
	  then(function(response) {
		  $scope.livre = response.data;
	  });
	
	$scope.modifierLivre = function(livre) {
		$http({
		    method: 'PUT',
		    url: 'http://localhost:8080/livre',
		    data: livre,
		    headers: {'Content-Type': 'application/json'}
		});
	};
});

rentControllers.controller("rentControllerFilm", function($scope,$http,$routeParams) {
	$http.get('http://localhost:8080/film').
	  then(function(response) {
	  	$scope.listeFilms = response.data;
	  	$scope.selected = response.data[0];
	  });
	
	$scope.choisirFilm = function(selected) {
		$http({
		    method: 'POST',
		    url: 'http://localhost:8080/film',
		    data: selected,
		    headers: {'Content-Type': 'application/json'}
		});
	};  
}); 

rentControllers.controller("modifierControllerFilm", function($scope,$http,$routeParams) {
	$http.get('http://localhost:8080/film/La belle et la bete').
	  then(function(response) {
		  $scope.film = response.data;
	  });
	
	$scope.modifierFilm = function(film) {
		$http({
		    method: 'PUT',
		    url: 'http://localhost:8080/film',
		    data: film,
		    headers: {'Content-Type': 'application/json'}
		});
	};
}); 