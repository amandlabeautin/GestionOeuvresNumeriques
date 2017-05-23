angular
    .module('GestionOeuvresNumeriques')
    .controller('homeCtrl', homeCtrl)
    .controller('inscriptionController', inscriptionController)
    .controller('filmController', filmController)
    .controller('livreController', livreController)
    .controller('selectMovieController', selectMovieController)
    .controller('adminController', adminController)
    .controller('shoppingBasketController', shoppingBasketController);

function homeCtrl($scope,$http,$routeParams){
	$http.get('http://localhost:8080/oeuvres/allOeuvre',{params: {typeValue: "F"}}).
		then(function(responseF) {
		  	$scope.listeFilms = responseF.data;
		});
	$http.get('http://localhost:8080/oeuvres/allOeuvre',{params: {typeValue: "L"}}).
		then(function(response) {
			$scope.listeLivres = response.data;
		  });
	$scope.decode = function(url) {
		return window.decodeURIComponent(url);
	} 

	$scope.searchData = function(search) {

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
        	$http.get('http://localhost:8080/users/add',{params: {'name': user.login, 'password' : user.password}}).
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
		var promise = $http.get('http://localhost:8080/oeuvres/addMovie',{params: {'titre': movie.titre, 'dateDeParution' : dateParution, 'resume' : movie.summary, 'image' : urlImageEncode, 'filmDuree' : movie.duree, 'filmAnnonce' : urlVideoEncode, 'acteurs' : acteurS, 'genres' : genreS}}).
                        then(function  (response) {
            $location.path('/gestionOeuvresNumeriques/admin');
        });
        return promise;
	}

	
	$scope.toggle = function() {
        $scope.change = !$scope.change;
    };

    $scope.addShoppingBasket = function(data){
    	console.log(data);
    }
};

function livreController($scope, $http, $routeParams, $sce) {
	$http.get('http://localhost:8080/oeuvres/allOeuvre',{params: {typeValue: "L"}}).
		then(function(responseL) {
		  	$scope.listeBooks = responseL.data;
	});

	$scope.decode = function(url) {
		var decodeUrl = window.decodeURIComponent(url);
		return $sce.trustAsResourceUrl(decodeUrl);
	}; 

	$scope.showDetailsBook = function(selected) {
		$http.get('http://localhost:8080/oeuvres/searchByTitre',{ params: {titre: selected.titre}}).
		    then(function(responseSelected) {
				$scope.selectedBook = responseSelected.data;
		});
		$scope.detailsBook = true;
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

function selectMovieController($scope,$http,$routeParams, UserService){
	$http.get('http://localhost:8080/oeuvres/allOeuvre',{params: {typeValue: "F"}}).
		then(function(responseF) {
		  	$scope.listeFilms = responseF.data;
	});

	$scope.decode = function(url) {
		return window.decodeURIComponent(url);
	}; 

	$scope.showDetailsMovie = function(selected) {
		$http.get('http://localhost:8080/oeuvres/searchByTitre',{ params: {titre: selected.titre}}).
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

	$scope.addShoppingBasket = function(selectShopping) {
		var oeuvreCollection = [];

		$http({
		    method: 'POST',
		    url: 'http://localhost:8080/oeuvres/findByTitleForId',
		    params: {'title': selectShopping.titre},
		    headers: {'Content-Type': 'application/json'}
		})
		.then(function  (response) { 
			$scope.idOeuvres = response.data;
			oeuvreCollection.push($scope.idOeuvres);
			console.log(oeuvreCollection);
			var responsejson = $http.get('http://localhost:8080/commandes/add',{params : {'user': UserService.getUser().id, 'oeuvre': oeuvreCollection}})
				.then(function  (response) { 
					console.log('then = ' + response);
        		})
        		.catch(function(response) {
        			console.log(response);
				});
			return responsejson;
		});

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
				$scope.selectedAllDatas = $scope.listeActeurs;
				break;
			case "auteur":
				$scope.selectedAllDatas = $scope.listeAuteurs;
				break;
			case "editeur":
				$scope.selectedAllDatas = $scope.listeEditeurs;
				break;
			case "genre":
				$scope.selectedAllDatas = $scope.listeGenres;
		};
		return $scope.selectedAllDatas;
	};

	$scope.addDataAdmin = function(object) {
		
	};

	$scope.editData = function(selectData, object){
		var urlData;
		console.log(selectData);
		console.log("object : " + object);

		switch(object) {
			case "acteur":
				urlData = 'http://localhost:8080/acteurs';
				break;
			case "auteur":
				urlData = 'http://localhost:8080/auteurs';
				break;
			case "editeur":
				urlData = 'http://localhost:8080/editeurs';
				break;
			case "genre":
				urlData = 'http://localhost:8080/genres';
		};
		$http({
		    method: 'PUT',
		    url: urlData,
		    data: {'id': selectData.id, 'name' : selectData.name},
		    headers: {'Content-Type': 'application/json'}
		}).catch(function(data, status) {
			console.log(status);
			console.log(data);
		});
	}
};

function shoppingBasketController($scope, $http, UserService){
	$scope.button = "Telecharger";
	var oeuvreCollection = [];

	$http.get('http://localhost:8080/users/allCommandeForUser',{params: {user: UserService.getUser().id}})
		.then(function(response) {
		  	$scope.listCommande = response.data;
		})
		.catch(function(response) {
        	console.log(response);
	});

	function convertDate(dateParution){
		dateParution = new Date(dateParution);
	    var d = dateParution.getDate().toString();
	    var dd = (d.length === 2) ? d : "0"+d;
	    var m = (dateParution.getMonth()+1).toString();
	    var mm = (m.length === 2) ? m : "0"+m;     
	    
	    return(dd+"/"+mm+ "/" + (dateParution.getFullYear()).toString());
	};

	function decode(url) {
		return window.decodeURIComponent(url);
	}; 

	function createJsPDF(oeuvre){
		var lMargin=20; //left margin in mm
	    var rMargin=20; //right margin in mm
	    var pdfInMM=210;
        var dateParution = convertDate(oeuvre.dateDeParution);
        var urlImage = decode(oeuvre.image);

        var doc = new jsPDF();
		doc.setFontSize(40);
		doc.text(35, 25, oeuvre.titre);
		doc.setLineWidth(1);

		doc.setFontSize(18);
		doc.setFontType('bold');
		doc.text(lMargin, 45, 'resume: ');
		doc.setFontSize(12);
		doc.setFontType('normal');
		var lines=doc.splitTextToSize(oeuvre.resume, (pdfInMM-lMargin-rMargin));
		doc.text(lMargin, 55, lines);

		doc.setFontSize(18);
		doc.setFontType('bold');
		doc.text(lMargin, 105, 'Date de parution : ');
		doc.setFontSize(12);
		doc.setFontType('normal');
		doc.text(lMargin, 115, dateParution);

		// If is a movie
		if(oeuvre.duree){
			doc.setFontSize(18);
			doc.setFontType('bold');
			doc.text(lMargin, 135, 'duree du film : ');
			doc.setFontSize(12);
			doc.setFontType('normal');
			doc.text(lMargin, 145, oeuvre.duree);
		}
		else{
			doc.setFontSize(18);
			doc.setFontType('bold');
			doc.text(lMargin, 135, 'nombre de pages : ');
			doc.setFontSize(12);
			doc.setFontType('normal');
			doc.text(lMargin, 145, oeuvre.nbreDePages.toString());
		}

	      // Save the PDF
	    doc.save(oeuvre.titre + '.pdf');
	};

	$scope.createPDF = function(oeuvre, idCommande){
		$http({
		    method: 'POST', url: 'http://localhost:8080/oeuvres/findByTitleForId', params: {'title': oeuvre.titre},
		    headers: {'Content-Type': 'application/json'}
		})
		.then(function  (response) {
			$scope.idOeuvre = response.data;
			$http.get('http://localhost:8080/commandes/update',{params: {'idCommande': idCommande, 'idOeuvre': $scope.idOeuvre}})
				.then(function(response) {
					console.log(response);
			  	createJsPDF(oeuvre);
			  	$scope.button = "deja telecharger";
			  	expect(element(by.css('button')).getAttribute('disabled')).toBeTruthy();
			})
			.catch(function(response) {
				console.log('error');
			});
		});
	};
};