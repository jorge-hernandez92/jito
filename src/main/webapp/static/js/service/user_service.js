'use strict';


App.factory('UserService', ['$http', '$q', function($http, $q){
	 
    return {
        	
    		//loggin 
    		login: function(user) {
    				return $http.post('http://localhost:8080/JProJS/login/', user)
    						.then(
    								function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching user');
                                        return $q.reject(errResponse);
                                    }
    						);	
    		},
    		
    		
    		checkSession : function() {
    				return $http.post('http://localhost:8080/JProJS/checkSession/')
    						.then(
    								function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Does not exist user session');
                                        return $q.reject(errResponse);
                                    }
    						);
    		}, 
 
    	
            fetchAllProduction: function() {
                    return $http.get('http://localhost:8080/JProJS/production/')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching users');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            addProduction: function(user){
                    return $http.post('http://localhost:8080/JProJS/addTomatoes/', user)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
         
    };
 
}]);