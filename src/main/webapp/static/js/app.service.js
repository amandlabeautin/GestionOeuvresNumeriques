angular
    .module('GestionOeuvresNumeriques')
    .service('UtilService', UtilService)
    .service('UserService', UserService);

function UtilService($rootScope, $cookieStore, Notification) {
    var self = this;
         
     self.fireInfoEvent = function(msg){
         var message = {type: 'info', 'msg':msg};
         $rootScope.$emit('NotificationEvent', message);
     };
     
     self.fireErrorEvent = function(msg){
         var message = {type: 'error', 'msg':msg};
         $rootScope.$emit('NotificationEvent', message);
     };
     
     self.notifyInfo = function(msg){
        Notification.primary(msg);
     };
     
     self.notifyError = function(msg){
         Notification.error(msg);
     };
};

function UserService($http, $state, $cookies) {
    var self = this;
            
    self.set = function(type, aUser){
        $cookies.put(type, aUser)
    };
        
    self.get = function(type){
        return $cookies.get(type);
    };

    self.getAll = function(){
        return $cookies.getAll();
    };
    
    self.isLoggedIn = function() {
        if(($cookies.get('role') == 'user') || ($cookies.get('role') == 'admin')) {
            return true;
        };
        return false;
    };

    self.isUserLoggedIn = function() {
        return $cookies.get('role') == 'user';
    }; 
    
    self.isAdminLoggedIn = function() {
        return $cookies.get('role') == 'admin';
    };
    
    self.logout = function() {
        $cookies.remove('role');
        $cookies.remove('id');
        $cookies.remove('username');
        $state.go('gestionOeuvresNumeriques',{},{reload: true});
    };   
};