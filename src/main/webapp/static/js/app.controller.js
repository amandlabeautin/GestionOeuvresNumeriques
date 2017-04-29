angular
    .module('GestionOeuvresNumeriques')
    .controller('rentController', rentController)
    .controller('modifierController', modifierController)
    .controller('rentControllerFilm', rentControllerFilm)
    .controller('modifierControllerFilm', modifierControllerFilm)
    .controller('homeCtrl', homeCtrl)
    .controller('inscriptionController', inscriptionController)
    .controller('filmController', filmController)
    .controller('livreController', livreController);;

function rentController($scope,$http,$routeParams) {
	$http.get('http://localhost:8080/livre').
	  then(function(response) {
	  	$scope.listeLivres = response.data;
	  	$scope.selected = response.data[0];
	  });
	
	$scope.choisirLivre = function(selected) {
		
		$http({
		    method: 'POST',
		    url: 'http://localhost:8080/livre',
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

function modifierController($scope,$http,$routeParams) {
	$http.get('http://localhost:8080/livre/50 nuances de sombres').
	  then(function(response) {
		  $scope.livre = response.data;
	  });
	
	$scope.modifierLivre = function(livre) {
		$http({
		    method: 'PUT',
		    url: 'http://localhost:8080/livre',
		    data: livre,
		    headers: {'Content-Type': 'application/json'}
		});
	};
};

function rentControllerFilm($scope,$http,$routeParams) {
	$http.get('http://localhost:8080/oeuvre/allFilms',{params: {typeValue: "F"}}).
	  	then(function(response) {
		  	console.log(response.data);
		  	$scope.listeFilms = response.data;
		  	$scope.selectedFilm = response.data[0];
		})
		.catch(function(response, status) {
			console.error('Gists error', response.status, response.data);
		})
		.finally(function() {
			console.log("finally finished gists");
		});
	
	$scope.choisirFilm = function(selected) {
		$http({
		    method: 'POST',
		    url: 'http://localhost:8080/oeuvre/allFilms',
		    params: {typeValue: "F"},
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

	$scope.decode = function(url) {
		return window.decodeURIComponent(url);
	} 
}; 

function modifierControllerFilm($scope,$http,$routeParams) {
	$http.get('http://localhost:8080/film/La belle et la bete').
	  then(function(response) {
		  $scope.film = response.data;
	  });
	
	$scope.modifierFilm = function(film) {
		$http({
		    method: 'PUT',
		    url: 'http://localhost:8080/film',
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
			console.log(response.data);
		  });
	$scope.decode = function(url) {
		return window.decodeURIComponent(url);
	} 
};

function inscriptionController($scope, $http,$routeParams){
	$scope.allUsers = function(){
		$http.get('http://localhost:8080/user/all').
	  then(function(response) {
	  	$scope.listeLivres = response.data;
	  	$scope.selected = response.data[0];
	  });

	}
	
 	$scope.createUser = function(user){
 		var promise = $http.get('http://localhost:8080/user/add',{params: {'name': user.login, 'password' : user.password}}).
                        then(function  (response) {
            return response.data;
        });
        return promise;
 	}
 
    /*fetchAllUsers();
 
    function fetchAllUsers(){
        UserService.fetchAllUsers()
            .then(
            function(d) {
                self.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
 
    function createUser(user){
        UserService.createUser(user)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }
 
    function updateUser(user, id){
        UserService.updateUser(user, id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }
 
    function deleteUser(id){
        UserService.deleteUser(id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }
 
    function submit() {
        if(self.user.id===null){
            console.log('Saving New User', self.user);
            createUser(self.user);
        }else{
            updateUser(self.user, self.user.id);
            console.log('User updated with id ', self.user.id);
        }
        reset();
    }
 
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    }
 
    function remove(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(id);
    }
 
 
    function reset(){
        self.user={id:null,username:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }*/
 
};

function filmController($scope, $http, $routeParams, $filter) {
	$scope.format = 'dd/MM/yyyy';
	
	$http.get('http://localhost:8080/genre/all').
		  then(function(response) {
		  	$scope.listeGenre = response.data;
		  	console.log(response.data);
		  });
	$http.get('http://localhost:8080/acteur/all').
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
		
		var promise = $http.get('http://localhost:8080/film/add',{params: {'titre': movie.titre, 'dateDeParution' : dateParution, 'resume' : movie.summary, 'image' : urlImageEncode, 'filmDuree' : movie.duree, 'filmAnnonce' : urlVideoEncode, 'acteurs' : acteurS, 'genres' : genreS}}).
                        then(function  (response) {
            return response.data;
        });
        return promise;
	}
};

function livreController($scope, $http, $routeParams, $filter) {
	$scope.format = 'dd/MM/yyyy';
	
	$http.get('http://localhost:8080/genre/all').
		  then(function(response) {
		  	$scope.listeGenre = response.data;
		  });
	$http.get('http://localhost:8080/auteur/all').
	  	then(function(response) {
		  	$scope.listeAuteur = response.data;
	  	});
	$http.get('http://localhost:8080/editeur/all').
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
		
		console.log(book.editeurSelected);
		var promise = $http.get('http://localhost:8080/book/add',{params: {'titre': book.titre, 'dateDeParution' : dateParution, 'resume' : book.summary, 'image' : urlImageEncode, 'auteurs' : auteurS, 'genres' : genreS, 'editeur' : book.editeurSelected['id'], 'nbreDePages' : book.nbreDePages}}).
                        then(function  (response) {
            return response.data;
        });
        return promise;
	}
}