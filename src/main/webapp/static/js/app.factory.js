angular
    .module('GestionOeuvresNumeriques')
    .factory('responseObserver', responseObserver);


function responseObserver($q, $window, $rootScope) {
	
	return {
        request: function (config) {
            return config || $q.when(config);
        },
        requestError: function(request){
            return $q.reject(request);
        },
        response: function (response) {
            return response || $q.when(response);
        },
        responseError: function (response) {
            if (response && response.status === 412) {
            	var message = {type: 'error', 'msg':'Problem in processing your request.'};
            	$rootScope.$emit('NotificationEvent', message);
            	$rootScope.logout();
            }
            if (response && response.status === 401) {
            	var message = {type: 'error', 'msg':'Invalid Login Credentials or Session Expired.'};
            	$rootScope.$emit('NotificationEvent', message);
            	$rootScope.logout();
            }
            return $q.reject(response);
        }
    };
    
};