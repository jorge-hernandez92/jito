'use strict';


App.factory('UserService', ['$http', '$q', function($http, $q){
	 
    return {
        	
    		//loggin 
    		login: function(user) {
    				return $http.post('http://localhost:8081/JProJS/login/', user)
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
 
    	
            fetchAllUsers: function() {
                    return $http.get('http://localhost:8081/JProJS/user/')
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
             
            createUser: function(user){
                    return $http.post('http://localhost:8081/JProJS/user/', user)
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