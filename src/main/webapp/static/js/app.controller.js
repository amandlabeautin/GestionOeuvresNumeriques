angular
    .module('GestionOeuvresNumeriques')
    .controller('rentController', rentController)
    .controller('modifierControllerFilm', modifierControllerFilm)
    .controller('homeCtrl', homeCtrl)
    .controller('inscriptionController', inscriptionController)
    .controller('filmController', filmController)
    .controller('livreController', livreController)
    .controller('selectMovieController', selectMovieController)
    .controller('adminController', adminController)
    .controller('shoppingCart', shoppingCart);

function rentController($scope,$http,$routeParams) {
	$http.get('http://localhost:8080/oeuvre/allOeuvre',{params: {typeValue: "L"}}).
	  then(function(response) {
	  	$scope.listeLivres = response.data;
	  	$scope.selected = response.data[0];
	  });
	
	$scope.choisirLivre = function(selected) {
		$http({
		    method: 'POST',
		    url: 'http://localhost:8080/oeuvre/allOeuvre',
		    params: {typeValue: "L"},
		    data: selected,
		    headers: {'Content-Type': 'application/json'}
		});
	};
	
	$scope.convertDate = function(dateParution){
		dateParution = new Date(dateParution);
	    var d = dateParution.getDate().toString();
	    var dd = (d.length === 2) ? d : "0"+d;
	    var m = (dateParution.getMonth()+1).toString();
	    var mm = (m.length === 2) ? m : "0"+m;     
	    
	    return(dd+"/"+mm+ "/" + (dateParution.getFullYear()).toString());
	};
};

function modifierControllerFilm($scope,$http,$routeParams) {
	$http.get('http://localhost:8080/oeuvre/allOeuvre',{params: {typeValue: "F"}}).
	  then(function(response) {
		  $scope.listeFilms = response.data;
	  });
	
	$scope.modifierFilm = function(film) {
		$http({
		    method: 'PUT',
		    url: 'http://localhost:8080/oeuvre/search',
		    data: film,
		    headers: {'Content-Type': 'application/json'}
		});
	};
}; 

function homeCtrl($scope,$http,$routeParams){
	$http.get('http://localhost:8080/oeuvre/allOeuvre',{params: {typeValue: "F"}}).
		then(function(responseF) {
		  	$scope.listeFilms = responseF.data;
		});
	$http.get('http://localhost:8080/oeuvre/allOeuvre',{params: {typeValue: "L"}}).
		then(function(response) {
			$scope.listeLivres = response.data;
		  });
	$scope.decode = function(url) {
		return window.decodeURIComponent(url);
	} 
};

function inscriptionController($scope, $http,$routeParams, $location, $state, UtilService, UserService){
	$scope.loginUser = {};
	
 	$scope.createUser = function(user){
		var userExist = $http.get('http://localhost:8080/user/checkUserExists',{params: {'login': user.login}}).
        then(function  (response) { 
        	userExist = response.data;
        });
        if (userExist = false) {
        	$http.get('http://localhost:8080/user/add',{params: {'name': user.login, 'password' : user.password}}).
	            then(function  (response) {
		            if(response.data == 'SAVED') {
		            	$location.path('/home');
		            }})
				.catch(function(response, status) {
					console.error('Gists error', response.status, response.data);
						$scope.loginFailed = true;
        			UtilService.notifyError('Invalid Login Credentials');
			});
        } else {
        	$scope.inscriptionForm.$error.userExist = true;
        }
 	};

 	$scope.connectUser = function(user){
 		$http({
		    method: 'POST',
		    url: 'http://localhost:8080/users/login',
		    params: {'login': user.login, 'password' : user.password},
		    headers: {'Content-Type': 'application/json'}
		})
		.then(function  (response) { 
			console.log(response);
        	//UtilService.notifyInfo('Login successful');
			UserService.setUser(response.data);
			$state.transitionTo('home');
        },function(response) {
        	console.log(response)
				console.log('Login failed');
				$scope.loginFailed = true;
	        	UtilService.notifyError('Invalid Login Credentials');
		});
    };
};

function filmController($scope, $http, $routeParams, $filter, $location) {
	$scope.format = 'dd/MM/yyyy';
	$scope.change = true;
	
	$http.get('http://localhost:8080/genres/all').
		  then(function(response) {
		  	$scope.listeGenre = response.data;
		  	console.log(response.data);
		  });
	$http.get('http://localhost:8080/acteurs/all').
	  	then(function(response) {
		  	$scope.listeActeur = response.data;
	  	});

	$scope.createMovie = function(movie, selected){
		$scope.date = new Date(movie.dateDeParution);
		var dateParution = $filter('date')($scope.date, 'dd/MM/yyyy');
		var urlImageEncode = window.encodeURIComponent(movie.image);
		var urlVideoEncode = window.encodeURIComponent(movie.bandeAnnonce);

		var acteurS = [];
		var genreS = [];
		 for (var i = 0; i < movie.acteurSelected.length; i++) {
		 	acteurS.push(movie.acteurSelected[i]['idActeur']);
		 }
		  for (var i = 0; i < movie.genreSelected.length; i++) {
		 	genreS.push(movie.genreSelected[i]['idGenre']);
		 }
		console.log(movie);
		var promise = $http.get('http://localhost:8080/film/add',{params: {'titre': movie.titre, 'dateDeParution' : dateParution, 'resume' : movie.summary, 'image' : urlImageEncode, 'filmDuree' : movie.duree, 'filmAnnonce' : urlVideoEncode, 'acteurs' : acteurS, 'genres' : genreS}}).
                        then(function  (response) {
            $location.path('/gestionOeuvresNumeriques/admin');
        });
        return promise;
	}

	
	$scope.toggle = function() {
        $scope.change = !$scope.change;
    };
	$scope.modifierMovie = function(movie) {
		$http({
		    method: 'PUT',
		    url: 'http://localhost:8080/oeuvre/search',
		    data: film,
		    headers: {'Content-Type': 'application/json'}
		});
	};
};

function livreController($scope, $http, $routeParams, $filter) {
	$scope.format = 'dd/MM/yyyy';

	$http.get('http://localhost:8080/oeuvre/allOeuvre',{params: {typeValue: "L"}}).
		then(function(responseF) {
		  	$scope.listeBooks = responseF.data;
	});

	$scope.decode = function(url) {
		var decodeUrl = window.decodeURIComponent(url);
		console.log($sce.trustAsResourceUrl(decodeUrl));
		return $sce.trustAsResourceUrl(decodeUrl);
	}; 

	$scope.showDetailsBooks = function(selected) {
		$http.get('http://localhost:8080/oeuvre/searchByTitre',{ params: {titre: selected.titre}}).
		    then(function(responseSelected) {
				$scope.selectedBook = responseSelected.data;
		});
		$scope.detailsMovie = true;
	};

	$scope.convertDate = function(dateParution){
		dateParution = new Date(dateParution);
	    var d = dateParution.getDate().toString();
	    var dd = (d.length === 2) ? d : "0"+d;
	    var m = (dateParution.getMonth()+1).toString();
	    var mm = (m.length === 2) ? m : "0"+m;     
	    
	    return(dd+"/"+mm+ "/" + (dateParution.getFullYear()).toString());
	}; 
	
	$http.get('http://localhost:8080/genres/all').
		  then(function(response) {
		  	$scope.listeGenre = response.data;
		  });
	$http.get('http://localhost:8080/auteurs/all').
	  	then(function(response) {
		  	$scope.listeAuteur = response.data;
	  	});
	$http.get('http://localhost:8080/editeurs/all').
	  	then(function(response) {
		  	$scope.listeEditeur = response.data;
	  	});

	$scope.createBook = function(book, selected){
		$scope.date = new Date(book.dateDeParution);
		var dateParution = $filter('date')($scope.date, 'dd/MM/yyyy');
		var urlImageEncode = window.encodeURIComponent(book.image);

		var auteurS = [];
		var genreS = [];
		for (var i = 0; i < book.auteurSelected.length; i++) {
		 	auteurS.push(book.auteurSelected[i]['idAuteur']);
		}
		for (var i = 0; i < book.genreSelected.length; i++) {
		 	genreS.push(book.genreSelected[i]['idGenre']);
		}
		
		console.log(book);
		var promise = $http.get('http://localhost:8080/book/add',{params: {'titre': book.titre, 'dateDeParution' : dateParution, 'resume' : book.summary, 'image' : urlImageEncode, 'auteurs' : auteurS, 'genres' : genreS, 'editeur' : book.editeurSelected['id'], 'nbreDePages' : book.nbreDePages}}).
                        then(function  (response) {
            return response.data;
        });
        return promise;
	}
};

function selectMovieController($scope,$http,$routeParams, $sce){
	$http.get('http://localhost:8080/oeuvre/allOeuvre',{params: {typeValue: "F"}}).
		then(function(responseF) {
		  	$scope.listeFilms = responseF.data;
	});

	$scope.decode = function(url) {
		var decodeUrl = window.decodeURIComponent(url);
		console.log($sce.trustAsResourceUrl(decodeUrl));
		return $sce.trustAsResourceUrl(decodeUrl);
	}; 

	$scope.showDetailsMovie = function(selected) {
		$http.get('http://localhost:8080/oeuvre/searchByTitre',{ params: {titre: selected.titre}}).
		    then(function(responseSelected) {
				$scope.selectedFilm = responseSelected.data;
		});
		$scope.detailsMovie = true;
	};

	$scope.convertDate = function(dateParution){
		dateParution = new Date(dateParution);
	    var d = dateParution.getDate().toString();
	    var dd = (d.length === 2) ? d : "0"+d;
	    var m = (dateParution.getMonth()+1).toString();
	    var mm = (m.length === 2) ? m : "0"+m;     
	    
	    return(dd+"/"+mm+ "/" + (dateParution.getFullYear()).toString());
	}; 
};

function adminController($scope,$http,$routeParams,$uibModal) {

	$http.get('http://localhost:8080/acteurs/all').
		then(function(response) {
		  	$scope.listeActeurs = response.data;
		  	$scope.selectedAllData = $scope.listeActeurs;
	});

	$http.get('http://localhost:8080/auteurs/all').
		then(function(response) {
		  	$scope.listeAuteurs = response.data;
	});

	$http.get('http://localhost:8080/editeurs/all').
		then(function(response) {
		  	$scope.listeEditeurs = response.data;
	});

	$http.get('http://localhost:8080/genres/all').
		then(function(response) {
		  	$scope.listeGenres = response.data;
	});

	$scope.selectedData = function(object) {
		$scope.object = object;
		switch(object){
			case "acteur":
				$scope.selectedAllData = $scope.listeActeurs;
				break;
			case "auteur":
				$scope.selectedAllData = $scope.listeAuteurs;
				break;
			case "editeur":
				$scope.selectedAllData = $scope.listeEditeurs;
				break;
			case "genre":
				$scope.selectedAllData = $scope.listeGenres;
		};
		return $scope.selectedAllData;
	};

	$scope.addDataAdmin = function(object) {
		
	};
};

function shoppingCart($scope){

}