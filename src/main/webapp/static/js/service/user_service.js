'use strict';
App.factory('UserService', ['$http', '$q', function($http, $q){	 
    return { 
    		login: function(user) {
    				return $http.post('http://localhost:8080/jito/login/', user)
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
    				return $http.post('http://localhost:8080/jito/checkSession/')
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
                    return $http.get('http://localhost:8080/jito/production/')
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
                    return $http.post('http://localhost:8080/jito/addTomatoes/', user)
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