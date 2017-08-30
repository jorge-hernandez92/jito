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
				fetchAllProduction : function() {
					return $http.get('production/')
							.then(function(response) {
								return response.data;
							}, function(errResponse) {
								console.error('Error while fetching users');
								return $q.reject(errResponse);
							});
				},
				addProduction : function(harvestDto) {
					return $http.post('addProduction/', harvestDto)
							.then(function(response) {
								return response.data;
							}, function(errResponse) {
								console.error('Error while creating user');
								return $q.reject(errResponse);
							});
				},
				allProduction : function() {
					return $http.get('allProduction/')
							.then(function(response) {
								return response.data;
							}, function(errResponse) {
								console.error('Error while fetching users');
								return $q.reject(errResponse);
							});
				},
				deleteHarvest : function(idHarvest) {
			        return $http.delete('harvest/'+idHarvest)
			            .then(function (response) {
			            	return response.data;
			            },function(errResponse){
			                console.error('Error while deleting Harvest');
			                return $q.reject(errResponse);
			            });
			    },
			};
		} ]);