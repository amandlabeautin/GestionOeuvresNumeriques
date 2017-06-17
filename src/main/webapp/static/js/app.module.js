angular
   .module('GestionOeuvresNumeriques', [
   		'ui.bootstrap','ui.bootstrap.modal','ui.router','ngResource','ngCookies','ngSanitize','ui-notification','ngRoute'
	])
   .run(['$rootScope', '$state', '$timeout','UserService','UtilService','$transitions', '$trace',
	function ($rootScope, $state, $timeout, UserService, UtilService, $transitions, $trace) {

		$transitions.onStart( {}, function($transition$, event) {
			var nameR = $transition$.$to().name;
		    var access = $transition$.$to().access;

			if (access == 'admin' && UserService.isAdminLoggedIn()) {

			}
			else if (access == 'user' && UserService.isUserLoggedIn() ){

			}
			else if (nameR == 'login' && (UserService.isUserLoggedIn()||UserService.isAdminLoggedIn()) ){
				$state.transitionTo('gestionOeuvresNumeriques');
			}
			else if (access == 'public'){

			}
			else {
	    		$state.transitionTo('login');
	    	}
			
	    	//$rootScope.currentNavLink=toState.name;
		});

		$rootScope.$on('NotificationEvent', function (event, message) {
		  	  console.log(message);
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
	
		$rootScope.isLoggedIn = function(){
			return UserService.isLoggedIn();
		}
		
		$rootScope.isUserLoggedIn = function(){
	        return UserService.isUserLoggedIn();
		}

		$rootScope.isAdminLoggedIn = function(){
	        return UserService.isAdminLoggedIn();
		}
 
		$rootScope.logout = function()
		{
			console.log('Logging out..');
			UserService.logout();
			$state.transitionTo("login");
		}
	    
}]);