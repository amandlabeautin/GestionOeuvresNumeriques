angular
    .module('GestionOeuvresNumeriques')
	.config(function($routeProvider, $locationProvider, $httpProvider) {
		$locationProvider.hashPrefix('');
		
		$httpProvider.interceptors.push('responseObserver');
		$routeProvider.
			when('/gestionOeuvresNumeriques', {
				templateUrl: 'partials/menu.html',
				controller: 'homeCtrl',
				access: 'public'
			}).
			when('/gestionOeuvresNumeriques/listBook', {
				templateUrl: 'partials/book/listerLivres.html',
				controller: 'rentController',
				access: 'public'
			}).
			when('/gestionOeuvresNumeriques/select-Film', {
				templateUrl: 'partials/movie/selectMovie.html',
				controller: 'selectMovieController',
				access: 'public'
			}).
			when('/gestionOeuvresNumeriques/select-Book', {
				templateUrl: 'partials/book/listBook.html',
				controller: 'livreController'
			}).
			when('/gestionOeuvresNumeriques/modifierFilm', {
				templateUrl: 'partials/movie/modifierFilm.html',
				controller: 'modifierControllerFilm'
			}).
			when('/gestionOeuvresNumeriques/login', {
				templateUrl: 'partials/user/subscribe.html',
				controller: 'inscriptionController',
				access: 'public'
			}).
			when('/gestionOeuvresNumeriques/add-movie', {
				templateUrl: 'partials/movie/addMovie.html',
				controller: 'filmController'
			}).
			when('/gestionOeuvresNumeriques/add-book', {
				templateUrl: 'partials/book/addBook.html',
				controller: 'livreController'
			}).
			when('/gestionOeuvresNumeriques/panier', {
				templateUrl: 'partials/shoppingBasket.html',
				controller: 'shoppingBasketController'
			}).
			when('/gestionOeuvresNumeriques/admin', {
				templateUrl: 'partials/admin/admin.html',
				controller: 'adminController'
			}).
			otherwise({
				redirectTo: '/gestionOeuvresNumeriques'
			});
	})
	.run(['$rootScope', '$state', '$timeout','UserService','UtilService',
    function ($rootScope, $state, $timeout, UserService, UtilService) {
	
	$rootScope.$on('$stateChangeStart', function(evt, toState, toParams, fromState, fromParams) {
		//console.log(toState);
    	//console.log(toState.name);
		var access = toState.access;
		//console.log(toState.access);
    	if(access != 'public'){
    		if(UserService.isUserLoggedIn()){
    			$rootScope.currentNavLink=toState.name;
    		} else {
    			evt.preventDefault();
    			console.log('redirect to login');
    			$state.go("/gestionOeuvresNumeriques/login");
    		}
    	}
		
    	//$rootScope.currentNavLink=toState.name;
	});
	
	$rootScope.$on('NotificationEvent', function (event, message) {
	  	  //console.log(message);
	  	  $rootScope.message = message;
	  	  if(message.type == 'error'){
	  		UtilService.notifyError(message.msg);
	  	  } else {
	  		UtilService.notifyInfo(message.msg);
	  	  }
	  	  
	  	  $timeout(function(){
	  		  delete $rootScope.message;
	  	  }, 3000);
	 });
	
	$rootScope.isUserLoggedIn = function(){
        return UserService.isUserLoggedIn();
	}
 
	$rootScope.logout = function()
	{
		console.log('Logging out..');
		UserService.logout();
		$state.transitionTo("login");
	}
	    
}])
;