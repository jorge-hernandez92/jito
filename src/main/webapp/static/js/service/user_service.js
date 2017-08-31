'use strict';
App.factory('UserService', [
		'$http',
		'$q',
		function($http, $q) {
			return {
				login : function(user) {
					return $http
							.post('login/', user)
							.then(function(response) {
								return response.data;
							}, function(errResponse) {
								console.error('Error al iniciar sesión');
								return $q.reject(errResponse);
							});
				},
				checkSession : function() {
					return $http.post('checkSession/').then(
							function(response) {
								return response.data;
							}, function(errResponse) {	
								console.error('Does not exist user session');
								return $q.reject(errResponse);
							});
				},
				logout : function() {
					return $http.get('logout/').then(
							function(response) {
								return response.data;
							}, function(errResponse) {
								console.error('Does not exist user session');
								return $q.reject(errResponse);
							});
				},
			};
		} ]);