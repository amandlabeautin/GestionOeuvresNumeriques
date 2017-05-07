angular
    .module('GestionOeuvresNumeriques')
    .directive('equalsTo', equalsTo)
    .directive('showWhenConnected', showWhenConnected)
    .directive('hideWhenConnected', hideWhenConnected);

function equalsTo() {
       /*
       * <input type="password" ng-model="Password" />
       * <input type="password" ng-model="ConfirmPassword" equals-to="Password" />
       */
	return {
        require: 'ngModel',
        link: function (scope, elm, attrs, ctrl) {
            ctrl.$parsers.unshift(function (viewValue, $scope) {
                var noMatch = viewValue != scope.inscriptionForm.password.$viewValue
                ctrl.$setValidity('noMatch', !noMatch)
                scope.passwordCGood = !noMatch
            })
        }
   };
};

function showWhenConnected(userService) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var showIfConnected = function() {
                if(userService.isConnected()) {
                    element.removeClass("ng-hide");
                } else {
                  console.log(element);
                    element.addClass("ng-hide");
                }
            };
 
            showIfConnected();
            scope.$on("connectionStateChanged", showIfConnected);
        }
    };
};

function hideWhenConnected(userService) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var hideIfConnected = function() {
                if(userService.isConnected()) {
                    element.addClass("ng-hide");
                } else {
                    element.removeClass("ng-hide");
                }
            };
 
            hideIfConnected();
            scope.$on("connectionStateChanged", hideIfConnected);
        }
    };
};