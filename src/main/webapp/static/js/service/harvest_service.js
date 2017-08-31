'use strict';
 
angular.module('myApp').factory('HarvestService', ['$http', '$q', function($http, $q){
	
    var factory = {
    	addProduction: addProduction,
    	allProduction: allProduction,
    	deleteHarvest: deleteHarvest
    };
 
    return factory;
    
    function addProduction(harvestDto) {
    	var deferred = $q.defer();
		$http.post('addProduction/', harvestDto)
				.then(function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error('Error while creating user');
					deferred.reject(errResponse);
				});
		return deferred.promise;
	}
    
	function allProduction() {
		var deferred = $q.defer();
		$http.get('allProduction/')
				.then(function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error('Error while fetching users');
					deferred.reject(errResponse);
				});
		return deferred.promise;
	}
	
	function deleteHarvest(idHarvest) {
		var deferred = $q.defer();
        $http.delete('harvest/'+idHarvest)
            .then(function (response) {
            	deferred.resolve(response.data);
            },function(errResponse){
                console.error('Error while deleting Harvest');
                deferred.reject(errResponse);
            });
        return deferred.promise;
    }
 
}]);