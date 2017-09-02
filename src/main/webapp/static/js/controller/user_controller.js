'use strict';

App.controller('UserController', ['$scope','UserService','HarvestService',
	
		function($scope, UserService, HarvestService) {
			var self = this;
			self.users = [];

			self.btnLogout = function() {
				UserService.logout().then(function(d) {
					window.location.href = "home";
				}, function(errResponse) {
					console.error('Error al iniciar sesion');
				});				
			};
			
			self.reset = function() {
				self.user = {};
				$scope.myForm.$setPristine(); 
			};
			
			$scope.save = function(harvest) {
				HarvestService.addProduction(harvest)
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
				$scope.harvest = {'idHarvest':null,'price':null, 'weight':null,'date':new Date()};
			};
			
			$scope.resetHarvest();
			
			$scope.allProduction = function() {
				HarvestService.allProduction().then(function(d) {
					for(var i = 0; i < d.length; i++){
						var date = moment(d[i].date).format('LL');
						d[i].FormatingDate = date;
					}
					$scope.listHarvest = d;
				}, 
				function(errResponse) {
					console.error('Error lista de producción');
				});
			};
			
			$scope.editHarvest = function(harvest) {
				$scope.harvest = {
						'idHarvest':harvest.idHarvest,
						'price':harvest.price, 
						'weight':harvest.weight,
						'date':new Date(harvest.date)
						};
			};
			
			$scope.deleteHarvest = function(harvest) {
				HarvestService.deleteHarvest(harvest.idHarvest).then(function(data){
					$scope.allProduction();
					$scope.resetHarvest();
				},function(errResponse){
					console.error('Error while deleting User');
	            });
			};
			
			$scope.allProduction();
			
			
			
		}]
);


