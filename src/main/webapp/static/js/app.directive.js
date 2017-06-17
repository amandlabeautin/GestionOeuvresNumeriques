angular
	.module('GestionOeuvresNumeriques')
	.directive('validPasswordCheck', validPasswordCheck)
	.directive('showWhenConnected', showWhenConnected)
	.directive('hideWhenConnected', hideWhenConnected)
	.directive('backImg',backImg);

function validPasswordCheck() {

	return {
		require: 'ngModel',
		scope: {

		  reference: '=validPasswordCheck'

		},
		link: function(scope, elm, attrs, ctrl) {
		  ctrl.$parsers.unshift(function(viewValue, $scope) {

			var noMatch = viewValue != scope.reference
			ctrl.$setValidity('noMatch', !noMatch);
			return (noMatch)?noMatch:!noMatch;
		  });

		  scope.$watch("reference", function(value) {;
			ctrl.$setValidity('noMatch', value === ctrl.$viewValue);

		  });
		}
	}
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

function backImg() {
	return function(scope, element, attrs) {
		var url = attrs.backImg;
        element.css({
            'background-image': 'url(' + url +')',
            'background-size' : 'cover'
        });
	};
};