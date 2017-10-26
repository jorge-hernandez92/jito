'use strict';

App.controller('Harvest2Controller', ['$scope','HarvestService','DTOptionsBuilder', 'DTColumnBuilder',
	function($scope,HarvestService, DTOptionsBuilder, DTColumnBuilder) {
	
//	production();
//	
//	$scope.editHarvest = editHarvest; 
//	
//	
//	function production() {
//		HarvestService.allProduction().then(function(d) {
//			for(var i = 0; i < d.length; i++){
//				var date = moment(d[i].date).format('LL');
//				d[i].formatDate = date;
//			}
//			$scope.listHarvest = d;
//			console.log($scope.listHarvest);
//			$('#example2').DataTable( {
//				language: {
//                    sZeroRecords: 'No se encontraron resultados',
//                    sInfo: 'Mostrando registros del _START_ al _END_ de _TOTAL_ registros',
//                    sLengthMenu: 'Mostrar _MENU_ registros',
//                    sSearch: 'Buscar:',
//                    buttons: {
//                        pageLength: {
//                            _: "Mostrar %d registros",
//                            '-1': "Mostrar todo"
//                        }
//                    },
//                    oPaginate: {
//                        sFirst: 'Primero',
//                        sLast: 'Último',
//                        sNext: 'Siguiente',
//                        sPrevious: 'Anterior'
//                    }
//                },
//		        data: d,
//		        columns: [
//		        	{ data:'weight', title: "Peso Total", },
//		        	{ data:'price', title: "Precio Total" },
//		        	{title:"Precio por Kilo",render: function (data, type, full, meta) {
//		        		return '$ '+full.price;
//		        		}	
//		        	},
//		            {title: "Fecha",render: function (data, type, full, meta) {
//	            		return moment(full.date).format('ll');
//	            		}
//		        	},
//		        	{data: function (fb) {
//		        		var btnSave = '<button type="button" class="btn btn-outline-success" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>';
//						var btnDelete = '<button type="button" class="btn btn-outline-danger" style="margin-left: 5px;"><i class="fa fa-trash-o" aria-hidden="true"></i></button>';
//						return btnSave + btnDelete;
//						}
//		        	}
//		        ]
//		    } );
//			
//		}, 
//		function(errResponse) {
//			console.error('Error lista de producción');
//		});
//	};
	
	
	
//	var vm = this;
//    vm.dtOptions = DTOptionsBuilder.fromFnPromise(function() {
//    	return HarvestService.allProduction();
//        
//    }).withPaginationType('full_numbers');
//    
//    vm.dtColumns = [
//        DTColumnBuilder.newColumn('weight').withTitle('Peso Total'),
//        DTColumnBuilder.newColumn('price').withTitle('Precio')
//    ];
//	
//	 console.log(DTOptionsBuilder);
//	 console.log(DTColumnBuilder);
	
	}

]);


