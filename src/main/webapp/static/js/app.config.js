angular
    .module('GestionOeuvresNumeriques')
	.config(function($stateProvider, $locationProvider, $urlRouterProvider) {
		$locationProvider.hashPrefix('');
		$stateProvider
			.state('gestionOeuvresNumeriques', {
				url : '/',
				templateUrl: 'partials/menu.html',
				controller: 'homeCtrl',
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
			.state('login', {
				url : '/login',
				templateUrl: 'partials/user/subscribe.html',
				controller: 'inscriptionController',
				access: 'public'
			})
			.state('add-movie', {
				url : '/add-movie',
				templateUrl: 'partials/movie/addMovie.html',
				controller: 'filmController'
			})
			.state('add-book', {
				url : '/add-book',
				templateUrl: 'partials/book/addBook.html',
				controller: 'livreController'
			})
			.state('panier', {
				url : '/panier',
				templateUrl: 'partials/shoppingBasket.html',
				controller: 'shoppingBasketController'
			})
			.state('admin', {
				url : '/admin',
				templateUrl: 'partials/admin/admin.html',
				controller: 'adminController'
			});
			$urlRouterProvider.otherwise('/');
	})
	.run(['$rootScope', '$state', '$timeout','UserService','UtilService',
	    function ($rootScope, $location, $timeout, UserService, UtilService) {
		
			$rootScope.$on('$stateChangeStart', function(evt, toState, toParams, fromState, fromParams) {
				console.log(toState);
		    	console.log(toState.name);
				var access = toState.access;
				console.log(toState.access);
		    	if(access != 'public'){
		    		if(UserService.isUserLoggedIn()){
		    			$rootScope.currentNavLink=toState.name;
		    		} else {
		    			evt.preventDefault();
		    			console.log('redirect to login');
		    			$location.path("/");
		    		}
		    	}else{
		    		$location.path("/home");
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

			$rootScope.isAdminLoggedIn = function(){
		        return UserService.isAdminLoggedIn();
			}
	 
			$rootScope.logout = function()
			{
				console.log('Logging out..');
				UserService.logoutAdmin();
				$location.path('/');
			}
		}
	]);