angular
    .module('GestionOeuvresNumeriques')
	.config(function($routeProvider, $locationProvider) {
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
			when('/gestionOeuvresNumeriques/inscription', {
				templateUrl: 'partials/inscription.html',
				controller: 'inscriptionController'
			}).
			when('/gestionOeuvresNumeriques/ajouter-film', {
				templateUrl: 'partials/addFilm.html',
				controller: 'filmController'
			}).
			when('/gestionOeuvresNumeriques/add-book', {
				templateUrl: 'partials/ajouterLivre.html',
				controller: 'livreController'
			}).
			otherwise({
				redirectTo: '/gestionOeuvresNumeriques'
			});
	});