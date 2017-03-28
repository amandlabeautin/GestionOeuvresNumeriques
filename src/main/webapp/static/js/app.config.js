'use strict';

angular
  .module('GestionOeuvresNumeriques')
  .config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
			when('/gestionLivres', {
				templateUrl: 'partials/menu.html'
			}).
			when('/gestionLivres/listeLivres', {
				templateUrl: 'partials/listerLivres.html',
				controller: 'rentController'
			}).
			otherwise({
				redirectTo: '/gestionLivres'
			});
  	}
  ]);
