'use strict';

angular.module('myApp').factory('SessionService', ['$http', '$q', function ($http, $q) {

	var factory = {
		login: login,
		logout: logout,
		checkSession: checkSession
	};

	return factory;

	function login(user) {
		var deferred = $q.defer();
		$http.post('login/', user).then(function (response) {
			deferred.resolve(response.data);
		}, function (errResponse) {
			console.error('Error al iniciar sesión');
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}

	function checkSession() {
		var deferred = $q.defer();
		$http.post('checkSession/').then(function (response) {
			deferred.resolve(response.data);
		}, function (errResponse) {
			console.error('Does not exist user session');
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}

	function logout() {
		var deferred = $q.defer();
		$http.get('logout/').then(function (response) {
			deferred.resolve(response.data);
		}, function (errResponse) {
			console.error('Does not exist user session');
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}
	
}]);