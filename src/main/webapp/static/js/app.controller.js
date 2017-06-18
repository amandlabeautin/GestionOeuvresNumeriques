angular
    .module('GestionOeuvresNumeriques')
    .controller('homeCtrl', homeCtrl)
    .controller('inscriptionController', inscriptionController)
    .controller('filmController', filmController)
    .controller('livreController', livreController)
    .controller('adminController', adminController)
    .controller('acteurController', acteurController)
    .controller('shoppingBasketController', shoppingBasketController);

function homeCtrl($scope, $sce, $http, UserService){
	$http.get('http://localhost:8080/oeuvres/searchByTitre',{params: {titre: "Wonder Woman"}}).
        then(function  (response) {
		  	$scope.wonder = response.data;
        });
    $http.get('http://localhost:8080/oeuvres/searchByTitre',{params: {titre: "13 Reasons Why"}}).
        then(function  (response) {
		  	$scope.reasonsWhy = response.data;
        });

	$scope.decode = function(url) {
		var decodeUrl = window.decodeURIComponent(url);
		return $sce.trustAsResourceUrl(decodeUrl);
	};

	$scope.convertDate = function(dateParution){
		dateParution = new Date(dateParution);
	    var d = dateParution.getDate().toString();
	    var dd = (d.length === 2) ? d : "0"+d;
	    var m = (dateParution.getMonth()+1).toString();
	    var mm = (m.length === 2) ? m : "0"+m;     
	    
	    return(dd+"/"+mm+ "/" + (dateParution.getFullYear()).toString());
	};

	$scope.handleSuccess = function (data) {
		$log.info('Modal closed: ' + data);
	};

	// Log Dismiss message
	$scope.handleDismiss = function (reason) {
		$log.info('Modal dismissed: ' + reason);
	};

	function addAlert(type, msg){
		$scope.alerts.push({
			type : type,
			msg : msg
		});
	};

	$scope.closeAlert = function(index) {
	    $scope.alerts.splice(index, 1);
	};
};

function acteurController($scope,$http, $uibModal){
	$http.get('http://localhost:8080/acteurs/all').
		then(function(response) {
			$scope.listeActeurs = response.data;
			for (var i = 0; i < $scope.listeActeurs.length; i++) {
				if($scope.listeActeurs[i].photo == null){
					$scope.listeActeurs[i].photo = 'https%3A%2F%2Fs-media-cache-ak0.pinimg.com%2Foriginals%2Fcc%2Fbb%2Fc5%2Fccbbc5690e2e63c8672f1fc4cbc28342.jpg';
				}
			}
		});
	$scope.showDetailsActeur = function(acteur){
		$http.get('http://localhost:8080/acteurs/listMoviesByActeur',{params: {acteur: acteur.name}}).
		then(function(response) {
		  	$scope.listeMovies = response.data;
		  	openModal(acteur, $scope.listeMovies);
		});
	};

	var openModal = function(acteur, movies) {
		$scope.acteur = acteur;
		$scope.movies = movies;
		modalShowDetailMovie($scope).result
	        .then(function (data) {
	            $scope.handleSuccess(data);
	        })
	        .then(null, function (reason) {
	            $scope.handleDismiss(reason);
	        });
	};

	var modalShowDetailMovie = function($scope) {
      return $scope.modalInstance = $uibModal.open({
          templateUrl: 'partials/acteur/modalShowMoviesByActeur.html',
          size:'lg',
          scope: $scope
        });
    };

    $scope.cancel = function () {
        $scope.modalInstance.dismiss('No Button Clicked');
    };
};

function inscriptionController($scope, $http,$routeParams, $state, UtilService, UserService, md5){
	$scope.loginUser = {};
	$scope.alerts = [];
	
 	$scope.createUser = function(user){
 		var userExist; 
		$http.get('http://localhost:8080/users/checkUserExists',{params: {'login': user.login}}).
        then(function  (response) {
        	userExist = response.data;
        	if (userExist == false) {
        		user.password = md5.createHash(user.password || '');
	        	$http.get('http://localhost:8080/users/add',{params: {'name': user.login, 'password' : user.password, 'isAdmin' : false}}).
		            then(function  (response) {
			            addAlert('alert-success','Vous pouvez maintenant vous connecter dans la partie gauche de la page.');
			       	})
					.catch(function(response, status) {
						console.error('Gists error', response.status, response.data);
						$scope.loginFailed = true;
	        			UtilService.notifyError('Invalid Login Credentials');
					});
	        };
        });
 	};

 	$scope.connectUser = function(user){
 		user.password = md5.createHash(user.password || '');
 		$http({
		    method: 'POST',
		    url: 'http://localhost:8080/users/login',
		    params: {'login': user.login, 'password' : user.password},
		    headers: {'Content-Type': 'application/json'}
		})
		.then(function  (response) { 
			if (response.data == ""){
				addAlert('alert-danger','Le mot de passe ou le login sont incorrectes  !');
			}
			else {
				if (response.data.isAdmin == false) {
            		UserService.set('role', 'user');
            		UserService.set('id', response.data.id);
            		UserService.set('username', response.data.username);
		        } else {
            		UserService.set('role', 'admin');
            		UserService.set('id', response.data.id);
            		UserService.set('username', response.data.username);
		        }
		        addAlert('alert-success','Vous êtes connecté !');
		        $state.go('gestionOeuvresNumeriques',{},{reload: true});
			}
        },function(response) {
	        	UtilService.notifyError('Invalid Login Credentials');
		});
    };

    function addAlert(type, msg){
		$scope.alerts.push({
			type : type,
			msg : msg
		});
	};

	$scope.closeAlert = function(index) {
	    $scope.alerts.splice(index, 1);
	};
};

function filmController($scope, $http, $routeParams, $sce, $filter, $state, UserService) {
	$scope.format = 'dd/MM/yyyy';
	$scope.alerts = [];
	$scope.change = true;
	$scope.IsHidden = true;

	$http.get('http://localhost:8080/oeuvres/allOeuvre',{params: {typeValue: "F"}}).
		then(function(responseF) {
		  	$scope.listeFilms = responseF.data;
	});
	$http.get('http://localhost:8080/genres/all').
		then(function(response) {
		  	$scope.listeGenre = response.data;
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
		 	acteurS.push(movie.acteurSelected[i]['id']);
		 }
		  for (var i = 0; i < movie.genreSelected.length; i++) {
		 	genreS.push(movie.genreSelected[i]['id']);
		 }
		var promise = $http.get('http://localhost:8080/oeuvres/addMovie',{params: {'titre': movie.titre, 'dateDeParution' : dateParution, 'resume' : movie.summary, 'image' : urlImageEncode, 'filmDuree' : movie.duree, 'filmAnnonce' : urlVideoEncode, 'acteurs' : acteurS, 'genres' : genreS}})
			.then(function  (response) {
				addAlert('alert-success','Le film a bien été ajouté à la base de données.');
				$state.go('admin');
        	})
        	.catch(function(response) {
			});
        return promise;
	}

	$scope.toggle = function() {
        $scope.change = !$scope.change;
    };

    $scope.addShoppingBasket = function(selectShopping){
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
			var responsejson = $http.get('http://localhost:8080/commandes/add',{params : {'user': UserService.get('id'), 'oeuvre': oeuvreCollection}})
				.then(function  (response) { 
					console.log('then = ' + response);
					addAlert('alert-success','Le livre a été ajouté à votre panier !');
        		})
        		.catch(function(response) {
        			console.log('then = ' + response);
        			addAlert('alert-danger','Erreur : console.log');
				});
			return responsejson;
		});
    };

    $scope.showDetailsMovie = function(selected) {
		$http.get('http://localhost:8080/oeuvres/searchByTitre',{ params: {titre: selected.titre}}).
		    then(function(responseSelected) {
				$scope.selectedFilm = responseSelected.data;
		});
		$scope.IsHidden = false;
	};

	function addAlert(type, msg){
		$scope.alerts.push({
			type : type,
			msg : msg
		});
	};

	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
	};
};

function livreController($scope, $http, $routeParams, $sce, UserService, $filter, $state) {
	$scope.IsHiddenBook = true;
	$scope.alerts = [];
	$http.get('http://localhost:8080/oeuvres/allOeuvre',{params: {typeValue: "L"}}).
		then(function(responseL) {
		  	$scope.listeBooks = responseL.data;
	});

	$http.get('http://localhost:8080/editeurs/all').
		then(function(responseL) {
		  	$scope.listeEditeurs = responseL.data;
	});

	$http.get('http://localhost:8080/auteurs/all').
		then(function(responseL) {
		  	$scope.listeAuteur = responseL.data;
	});

	$http.get('http://localhost:8080/genres/all').
		then(function(responseL) {
		  	$scope.listeGenre = responseL.data;
	});

	$scope.showDetailsBook = function(selected) {
		$http.get('http://localhost:8080/oeuvres/searchByTitre',{ params: {titre: selected.titre}}).
		    then(function(responseSelected) {
				$scope.selectedBook = responseSelected.data;
				$scope.IsHiddenBook = false;
		});
	};

	$scope.createBook = function(book, selected){
		$http.get('http://localhost:8080/auteurs/all').
			then(function(response) {
			  	$scope.listeAuteur = response.data;
		});
		$http.get('http://localhost:8080/editeurs/all').
			then(function(response) {
			  	$scope.listeEditeurs = response.data;
		});
		$http.get('http://localhost:8080/genres/all').
			then(function(response) {
			  	$scope.listeGenre = response.data;
		});

		$scope.date = new Date(book.dateDeParution);
		var dateParution = $filter('date')($scope.date, 'dd/MM/yyyy');
		var urlImageEncode = window.encodeURIComponent(book.image);
		var urlVideoEncode = window.encodeURIComponent(book.bandeAnnonce);

		var auteurS = [];
		var genreS = [];
		 for (var i = 0; i < book.auteurSelected.length; i++) {
		 	auteurS.push(book.auteurSelected[i]['id']);
		 }
		  for (var i = 0; i < book.genreSelected.length; i++) {
		 	genreS.push(book.genreSelected[i]['id']);
		 }

		var promise = $http.get('http://localhost:8080/oeuvres/addBook',{params: {'editeur': book.editeurSelected.id,'titre': book.titre, 'dateDeParution' : dateParution, 'resume' : book.summary, 'image' : urlImageEncode, 'nbreDePages' : book.nbreDePages, 'auteurs' : auteurS, 'genres' : genreS}})
			.then(function  (response) {
				addAlert('alert-success','Le livre a bien été ajouté à la base de données.');
            	$state.go('/admin');
        	})
        	.catch(function(response) {

			});
        return promise;
	}

	$scope.addShoppingBasket = function(selectShopping){
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
			var responsejson = $http.get('http://localhost:8080/commandes/add',{params : {'user': UserService.get('id'), 'oeuvre': oeuvreCollection}})
				.then(function  (response) { 
					console.log(response);
					addAlert('alert-success','Le livre a été ajouté à votre panier !');
        		})
        		.catch(function(response) {
        			console.log(response);
        			addAlert('alert-danger','Erreur : ' + response);
				});
			return responsejson;
		});
    };

    function addAlert(type, msg){
		$scope.alerts.push({
			type : type,
			msg : msg
		});
	};

	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
	};
};

function adminController($scope,$http,$routeParams,$uibModal, $log) {
	$scope.isPaginate = true;
	$scope.alerts = [];

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
		  	for (var i = 0; i < response.data.length; i++) {
				$scope.listeEditeurs[i].name = response.data[i].nomEditeur;
			}
	});

	$http.get('http://localhost:8080/genres/all').
		then(function(response) {
		  	$scope.listeGenres = response.data;
	});

	$http.get('http://localhost:8080/oeuvres/all').
		then(function(response) {
			$scope.listeOeuvres = response.data;
			for (var i = 0; i < response.data.length; i++) {
				$scope.listeOeuvres[i].name = response.data[i].titre;
			}
	});

	$scope.setPage = function (pageNo) {
	    $scope.currentPage = pageNo;
	};

	$scope.pageChanged = function() {
		console.log('Page changed to: ' + $scope.currentPage);
	};

	$scope.setItemsPerPage = function(num) {
	  	$scope.itemsPerPage = num;
	  	$scope.currentPage = 1; //reset to first paghe
	};

	$scope.selectedDataType = function(object) {
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
				break;
			case "oeuvre":
				$scope.selectedAllDatas = $scope.listeOeuvres;
		};

		$scope.viewby = 10;
	  	$scope.totalItems = $scope.selectedAllData.length;
	  	$scope.currentPage = 4;
	  	$scope.itemsPerPage = $scope.viewby;
	  	$scope.maxSize = 5; //Number of pager buttons to show
	  	$scope.isPaginate = false;
		return $scope.selectedAllDatas;
	};

    var modalAddData = function($scope) {
      return $scope.modalInstance = $uibModal.open({
          templateUrl: 'partials/admin/addDataAdmin.html',
          size:'lg',
          scope: $scope
        });
    };

    var modalEditData = function($scope) {
      return $scope.modalInstance = $uibModal.open({
          templateUrl: 'partials/admin/editDataAdmin.html',
          size:'lg',
          scope: $scope
        });
    };

    $scope.openEditModal = function(data, object) {
		$scope.subject = object;
		$scope.data = data;
		modalEditData($scope).result
	        .then(function (data) {
	            $scope.handleSuccess(data);
	        })
	        .then(null, function (reason) {
	            $scope.handleDismiss(reason);
	        });
	};

	$scope.openAddModal = function(object) {
		$scope.subject = object;
		modalAddData($scope).result
	        .then(function (data) {
	            $scope.handleSuccess(data);
	        })
	        .then(null, function (reason) {
	            $scope.handleDismiss(reason);
	        });
	};

	$scope.editDataAdmin = function(dataAdmin, subject){
		switch(subject){
			case "acteur":
				$scope.urlSpring = 'http://localhost:8080/acteurs/edit';
				break;
			case "auteur":
				$scope.urlSpring = 'http://localhost:8080/auteurs/edit';
				break;
			case "editeur":
				$scope.urlSpring = 'http://localhost:8080/editeurs/edit';
				break;
			case "genre":
				$scope.urlSpring = 'http://localhost:8080/genres/edit';
				break;
			case "oeuvre":
				$scope.urlSpring = 'http://localhost:8080/oeuvres/editAdmin';
				break;
		}

		if("image" in dataAdmin){
			dataAdmin.image = window.encodeURIComponent(dataAdmin.image);
		}
		if("photo" in dataAdmin){
			dataAdmin.photo = window.encodeURIComponent(dataAdmin.photo);
		}
		
		$http({
		    method: 'PUT',
		    url: $scope.urlSpring,
		    data: dataAdmin,
		    headers: {'Content-Type': 'application/json'}
		}).then(function(response) {
			console.log('success :' + response);
			$scope.modalInstance.dismiss('No Button Clicked');
			addAlert('alert-success', 'Les modifications ont été enregistrées.');			  	
		}).catch(function(response) {
	        console.log('error :' + response);
		});
	};

	$scope.saveDataAdmin = function(form, subject){
		switch(subject){
			case "acteur":
				$scope.urlSpring = 'http://localhost:8080/acteurs/add';
				break;
			case "auteur":
				$scope.urlSpring = 'http://localhost:8080/auteurs/add';
				break;
			case "editeur":
				$scope.urlSpring = 'http://localhost:8080/editeurs/add';
				break;
			case "genre":
				$scope.urlSpring = 'http://localhost:8080/genres/add';
				break;
		}
		$http.get($scope.urlSpring,{params: {'name': form.name}})
			.then(function(response) {
				$scope.modalInstance.dismiss('No Button Clicked');
				addAlert('alert-success', 'Le ou la '+subject+ ' a été enregistré(e).')
			  	
			})
			.catch(function(response) {
	        	console.log(response);
		});
	};
    
    $scope.cancel = function () {
        $scope.modalInstance.dismiss('No Button Clicked');
    };
	        // Log Success message
};

function shoppingBasketController($scope, $http, UserService, $sce){
	$scope.alerts = [];
	$scope.isDisabled = false;
	$scope.button = "Telecharger";
	var oeuvreCollection = [];

	$http.get('http://localhost:8080/users/allCommandeForUser',{params: {user: UserService.get('id')}})
		.then(function(response) {
		  	$scope.listCommande = response.data;
		  	if(response.data.length == 0) {
		  		addAlert('alert-danger','Votre panier est vide !');
		  	}
		  	else {
		  		var dateCommande = new Date($scope.listCommande[0].dateDeCommande);
			  	var d = new Date();
			  	var dateLimit = dateCommande.getTime() + (7 * 24 * 60 * 60 * 1000);
			  	if(dateLimit => d.getTime()) {
			  		addAlert('alert-warning','Certaines oeuvres sont à télécharger !');
			  	} else {
			  		addAlert('alert-danger','Attention ! Votre panier va expirée !');
			  	}
		  	}	  	
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
		var decodeUrl = window.decodeURIComponent(url);
		return $sce.trustAsResourceUrl(decodeUrl);
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

	function addAlert(type, msg){
		$scope.alerts.push({
			type : type,
			msg : msg
		});
	};

	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
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
			  		createJsPDF(oeuvre);
			  		$('#button'.idCommande).text = "déja télécharger";
			  		$scope.isDisabled = true;
			  		addAlert('alert-success','L\'oeuvre a été téléchargée !');
				})
				.catch(function(response) {
					console.log(response);
				});
		});
	};
};