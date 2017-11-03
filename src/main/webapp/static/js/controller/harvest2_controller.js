'use strict';

App.controller('Harvest2Controller', ['$scope','$compile', 'HarvestService','DTOptionsBuilder', 'DTColumnBuilder','$http', '$q',
	function($scope,$compile,HarvestService , DTOptionsBuilder, DTColumnBuilder,$http, $q) {
	
	var vm = this;
    vm.message = '';
    vm.edit = edit;
    vm.delete = deleteRow;
    vm.dtInstance = {};
    vm.persons = {};
    
	vm.displayTable = false;
	
	vm.dtOptions = DTOptionsBuilder.fromFnPromise(function() {
		var deferred = $q.defer();
		$http.get('allProduction/').then(function (response) {
				deferred.resolve(response.data);
			});
		
		return deferred.promise;
	})
	.withDOM('Bfrtip')
	.withPaginationType('full_numbers')
	.withOption('createdRow', createdRow)
	.withButtons(['pageLength',
		{
			'extend': 'excelHtml5',
			'text': 'Descargar Excel',
			'filename': 'Archivo de Ventas',
			'title': 'Lista de Ventas'
        },
        {
			'extend': 'pdfHtml5',
			'text': 'Descargar PDF',
			'filename': 'Archivo de Ventas',
        }
	])
	.withLanguageSource('static/Spanish.json');
				
				
	vm.dtColumns = [
		DTColumnBuilder.newColumn('weight').withTitle('Kilogramos').renderWith(formatWeight),
		DTColumnBuilder.newColumn('price').withTitle('Precio').renderWith(formatPrice),
		DTColumnBuilder.newColumn(null).withTitle('Precio por Kilo').renderWith(saleByKg),
		DTColumnBuilder.newColumn('date').withTitle('Fecha').renderWith(formatDate),
		DTColumnBuilder.newColumn(null).withTitle('Opciones').renderWith(actions)
	];
		
	vm.displayTable = true;
	
	function actions(data, type, full, meta){
		vm.persons[data.idHarvest] = data;
		var btnSave = '<button type="button" class="btn btn-outline-success" ng-click="showCase.edit(showCase.persons[' + data.idHarvest + '])"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>';
		var btnDelete = '<button type="button" class="btn btn-outline-danger" style="margin-left: 5px;" ng-click="showCase.delete(showCase.persons[' + data.idHarvest + '])" )"=""><i class="fa fa-trash-o" aria-hidden="true"></i></button>';
		return btnSave + btnDelete;
	}
	
	function formatDate(data, type, full, meta){
		return moment(data).format('ll');
	}
	
	function formatWeight(data, type, full, meta){
		return data + ' Kg';
	}
	
	function formatPrice(data, type, full, meta){
		console.log(full);
		return '$ '+ data.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + ' Pesos';
	}
	
	function saleByKg(data, type, full, meta){
		return '$ ' + (full.price / full.weight).toLocaleString() + ' Pesos';
	}
	
	function edit(person) {
        vm.message = 'You are trying to edit the row: ' + JSON.stringify(person);
        // Edit some data and call server to make changes...
        // Then reload the data so that DT is refreshed
        vm.dtInstance.reloadData();
    }
	function createdRow(row, data, dataIndex) {
        // Recompiling so we can bind Angular directive to the DT
        $compile(angular.element(row).contents())($scope);
    }
	function deleteRow(person) {
        vm.message = 'You are trying to remove the row: ' + JSON.stringify(person);
        // Delete some data and call server to make changes...
        // Then reload the data so that DT is refreshed
        vm.dtInstance.reloadData();
    }
    function deleteRow(person) {
        vm.message = 'You are trying to remove the row: ' + JSON.stringify(person);
        // Delete some data and call server to make changes...
        // Then reload the data so that DT is refreshed
        vm.dtInstance.reloadData();
    }
	
	}

]);


