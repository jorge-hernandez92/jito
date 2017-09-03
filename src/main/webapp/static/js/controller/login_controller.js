'use strict';

var AppL = angular.module('myAppL',[]);

AppL.controller('LoginController', [ '$scope', 'LoginService',
		function($scope, UserService) {
			var self = this;
			self.users = [];
			self.login = function() {
				UserService.login(self.user).then(function(d) {
					self.userLogin = d;
					console.log(d);
					window.location.href = "home";
					
				}, function(errResponse) {
					console.error('ERROR CON EL USUARIO');
				});
			}
			
		} ]);
