'use strict';

App.controller('HarvestController', ['$scope','HarvestService',
	
		function($scope,HarvestService) {
			var self = this;
			self.users = [];
			
			self.reset = reset;
			$scope.save = save; 
			$scope.resetHarvest = resetHarvest;
			$scope.allProduction = allProduction; 
			$scope.editHarvest = editHarvest;
			$scope.deleteHarvest = deleteHarvest; 
			
			allProduction();
			resetHarvest();
			
			function reset() {
				self.user = {};
				$scope.myForm.$setPristine(); 
			};
			
			function save(harvest) {
				harvest.onlyDate = moment(harvest.date).format('YYYY-MM-DD');
				console.log(harvest);
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

			function resetHarvest() {
				$scope.harvest = {'idHarvest':null,'price':null, 'weight':null,'date':new Date()};
			};
			
			
			function allProduction() {
				HarvestService.allProduction().then(function(d) {
					for(var i = 0; i < d.length; i++){
						var date = moment(d[i].date).format('LL');
						d[i].formatDate = date;
					}
					$scope.listHarvest = d;
				}, 
				function(errResponse) {
					console.error('Error lista de producción');
				});
			};
			
			function editHarvest(harvest) {
				$scope.harvest = {
						idHarvest:harvest.idHarvest,
						price:harvest.price, 
						weight:harvest.weight,
						date:new Date(harvest.date)
						};
			};
			
			function deleteHarvest (harvest) {
				HarvestService.deleteHarvest(harvest.idHarvest).then(function(data){
					$scope.allProduction();
					$scope.resetHarvest();
				},function(errResponse){
					console.error('Error while deleting User');
	            });
			};
			
		}]
);


