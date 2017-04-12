'use strict';

var app = angular.module('GestionOeuvresNumeriques', [
	'ngRoute','rentControllers']);

app.config(['$routeProvider',  '$locationProvider',
	function($routeProvider, $locationProvider) {
		$locationProvider.hashPrefix('');	
		$routeProvider.
			when('/gestionOeuvresNumeriques', {
				templateUrl: 'partials/menu.html'
			}).
			when('/gestionOeuvresNumeriques/listeLivres', {
				templateUrl: 'partials/listerLivres.html',
				controller: 'rentController'
			}).
			when('/gestionOeuvresNumeriques/modifierLivre', {
				templateUrl: 'partials/modifierLivre.html',
				controller: 'modifierController'
			}).
			otherwise({
				redirectTo: '/gestionOeuvresNumeriques'
			});
}]);