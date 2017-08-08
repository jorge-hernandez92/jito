'use strict';

App.controller('UserController', ['$scope','UserService',
	
	
		function($scope, UserService) {
			var self = this;
			self.users = [];
			self.date = new Date();
			
			this.myDate = new Date();
			this.isOpen = false;
			
			$scope.example = {
				value : new Date()
			};

			self.btnLogout = function() {
				console.log("btnLogout");
				UserService.logout().then(function(d) {
					window.location.href = "home";
				}, function(errResponse) {
					console.error('Error al iniciar sesion');
				});				
			}

			self.fetchAllProduction = function() {
				UserService.fetchAllProduction().then(function(d) {
					self.users = d;
				}, function(errResponse) {
					console.error('Error lista de producción');
				});
			};

			self.addProduction = function(user) {
				UserService.addProduction(user).then(self.fetchAllProduction,
						function(errResponse) {
							console.error('Error agregando producción.');
						});
			};
			
			self.reset = function() {
				self.user = {};
				$scope.myForm.$setPristine(); 
			};
			
			
			$scope.save = function(harvest) {
				console.log(harvest)
			};

			$scope.resetHarvest = function() {
				$scope.harvest = {'precio':0, 'peso':0};
			};
			
			$scope.resetHarvest();
		      
		      

		} ]);


