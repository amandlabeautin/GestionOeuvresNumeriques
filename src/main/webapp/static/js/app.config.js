angular
    .module('GestionOeuvresNumeriques')
	.config(function($stateProvider, $locationProvider, $urlRouterProvider) {
		$locationProvider.hashPrefix('');
		$stateProvider
			.state('gestionOeuvresNumeriques', {
				url : '/',
				templateUrl: 'partials/menu.html',
				access: 'public'
			})
			.state('select-Film', {
				url: '/select-Film',
				templateUrl: 'partials/movie/selectMovie.html',
				controller: 'filmController',
				access: 'public'
			})
			.state('select-Book', {
				url : '/select-Book',
				templateUrl: 'partials/book/listBook.html',
				controller: 'livreController',
				access: 'public'
			})
			.state('select-acteurs', {
				url : '/select-acteurs',
				templateUrl: 'partials/selectActeurs.html',
				controller: 'acteurController',
				access: 'public'
			})
			.state('login', {
				url : '/login',
				templateUrl: 'partials/user/subscribe.html',
				controller: 'inscriptionController',
				access: 'public'
			})
			.state('add-movie', {
				url : '/add-movie',
				templateUrl: 'partials/movie/addMovie.html',
				controller: 'filmController',
				access: 'admin'
			})
			.state('add-book', {
				url : '/add-book',
				templateUrl: 'partials/book/addBook.html',
				controller: 'livreController',
				access: 'admin'
			})
			.state('panier', {
				url : '/panier',
				templateUrl: 'partials/shoppingBasket.html',
				controller: 'shoppingBasketController',
				access: 'user'
			})
			.state('admin', {
				url : '/admin',
				templateUrl: 'partials/admin/admin.html',
				controller: 'adminController',
				access: 'admin'
			});
			$urlRouterProvider.otherwise('/');
	});