'use strict';

var app = angular.module('GestionOeuvresNumeriques', [
	'ngRoute','rentControllers']);

app.config(['$routeProvider',  '$locationProvider',
	function($routeProvider, $locationProvider) {
		$locationProvider.hashPrefix('');	
		$routeProvider.
			when('/gestionOeuvresNumeriques', {
				templateUrl: 'partials/menu.html',
				controller: 'homeCtrl'
			}).
			when('/gestionOeuvresNumeriques/listeLivres', {
				templateUrl: 'partials/listerLivres.html',
				controller: 'rentController'
			}).
			when('/gestionOeuvresNumeriques/modifierLivre', {
				templateUrl: 'partials/modifierLivre.html',
				controller: 'modifierController'
			}).
			when('/gestionOeuvresNumeriques/listeFilms', {
				templateUrl: 'partials/listerFilms.view.html',
				controller: 'rentControllerFilm'
			}).
			when('/gestionOeuvresNumeriques/modifierFilm', {
				templateUrl: 'partials/modifierFilm.html',
				controller: 'modifierControllerFilm'
			}).
			otherwise({
				redirectTo: '/gestionOeuvresNumeriques'
			});
}]);