'use strict';

angular.module('myAppL').factory('LoginService', ['$http', '$q', function ($http, $q) {

	var factory = {
		login: login,
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
	
}]);