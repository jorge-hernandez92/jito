'use strict';

App.controller('Harvest2Controller', ['$scope','HarvestService','DTOptionsBuilder', 'DTColumnBuilder','$http', '$q',
	function($scope,HarvestService, DTOptionsBuilder, DTColumnBuilder,$http, $q) {
	
	var vm = this;
	
	vm.displayTable = false;
	
	vm.dtOptions = DTOptionsBuilder.fromFnPromise(function() {
		var deferred = $q.defer();
		$http.get('allProduction/').then(function (response) {
				deferred.resolve(response.data);
			});
		
		return deferred.promise;
	}).withPaginationType('full_numbers');
				
				
	vm.dtColumns = [
		DTColumnBuilder.newColumn('weight').withTitle('Kilogramos').renderWith(formatWeight),
		DTColumnBuilder.newColumn('price').withTitle('Precio').renderWith(formatPrice),
		DTColumnBuilder.newColumn(null).withTitle('Precio por Kilo').renderWith(saleByKg),
		DTColumnBuilder.newColumn('date').withTitle('Fecha').renderWith(formatDate),
		DTColumnBuilder.newColumn(null).withTitle('Opciones').renderWith(actions)
	];
		
	vm.displayTable = true;
	
	function actions(data, type, full, meta){
		var btnSave = '<button type="button" class="btn btn-outline-success" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>';
		var btnDelete = '<button type="button" class="btn btn-outline-danger" style="margin-left: 5px;"><i class="fa fa-trash-o" aria-hidden="true"></i></button>';
		return btnSave + btnDelete;
	}
	
	function formatDate(data, type, full, meta){
		return moment(data).format('ll');
	}
	
	function formatWeight(data, type, full, meta){
		return data + ' Kg';
	}
	
	function formatPrice(data, type, full, meta){
		return '$ '+ data.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + ' Pesos';
	}
	
	function saleByKg(data, type, full, meta){
		return '$ ' + (full.price / full.weight).toLocaleString() + ' Pesos';
	}
	
	}

]);


