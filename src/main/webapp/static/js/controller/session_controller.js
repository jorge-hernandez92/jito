'use strict';

App.controller('SessionController', ['$scope','SessionService',
	
		function($scope,SessionService) {
			var self = this;
			self.users = [];
			
			self.btnLogout = function() {
				SessionService.logout().then(function(d) {
					window.location.href = "home";
				}, function(errResponse) {
					console.error('Error al iniciar sesion');
				});				
			};
		}]
);


