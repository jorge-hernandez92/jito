'use strict';

App.controller('UserController', ['$scope','UserService',
	
		function($scope, UserService) {
			var self = this;
			self.users = [];

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
				UserService.addProduction(harvest)
				.then(function(data){
					console.log(data);
					$scope.allProduction();
					$scope.resetHarvest();
				},
				function(errResponse) {
					console.error('Error agregando producción.');
				});
			};

			$scope.resetHarvest = function() {
				$scope.harvest = {'price':null, 'weight':null,'date':new Date()};
			};
			
			$scope.resetHarvest();
			
			$scope.allProduction = function() {
				UserService.allProduction().then(function(d) {
					for(var i = 0; i < d.length; i++){
						var date = moment(d[i].harvestCutDate).format('LL');
						d[i].harvestCutDate = date;
					}
					$scope.listHarvest = d;
				}, 
				function(errResponse) {
					console.error('Error lista de producción');
				});
			};
			
			$scope.allProduction();

		} ]);


