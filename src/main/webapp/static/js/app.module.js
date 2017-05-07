angular
   .module('GestionOeuvresNumeriques', [
   		'ui.bootstrap','ui.bootstrap.modal','ui.router','ngResource','ngCookies','ngSanitize','ui-notification','ngRoute'
	])
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
	    			$state.go("login");
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
	    
}]);