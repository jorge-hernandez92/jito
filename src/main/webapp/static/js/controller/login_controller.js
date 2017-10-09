'use strict';

AppLogin.controller('LoginController', [ '$scope', 'LoginService',
		function($scope, LoginService) {
			var self = this;
			self.users = [];

			self.login = function() {
				LoginService.login(self.user).then(function(d) {
					self.userLogin = d;
					console.log(d);
					window.location.href = "home";
				}, function(errResponse) {
					console.error('ERROR CON EL USUARIO');
				});
			}
		} 
]);
