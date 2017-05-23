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

function UserService($http, $state, $cookieStore, $location) {
    var self = this;
            
    self.setUser = function(aUser){
        $cookieStore.put('authenticatedUser', aUser);
    };
        
    self.getUser = function(){
        return $cookieStore.get('authenticatedUser');
    };
    
    self.isUserLoggedIn = function() {
        return $cookieStore.get('authenticatedUser') != null;
    };

    self.setAdmin = function(aUser){
        $cookieStore.put('authenticatedUser', aUser);
        $cookieStore.put('authenticatedAdmin', aUser);
    };
        
    self.getAdmin = function(){
        return $cookieStore.get('authenticatedAdmin');
    };
    
    self.isAdminLoggedIn = function() {
        return $cookieStore.get('authenticatedAdmin') != null;
    };
    
    self.logoutAdmin = function() {
        $cookieStore.remove('authenticatedUser');
        $cookieStore.remove('authenticatedAdmin');
        $location.path('/');
    };   
};