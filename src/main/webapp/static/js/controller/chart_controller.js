'use strict';

App.controller('ChartController', ['$scope', 'HarvestService', function ($scope, HarvestService) {
	var self = this;
	
	loadChart();
	
	function loadChart(){
		google.charts.load('current', { 'packages': ['line'], 'language': 'es'});
		google.charts.setOnLoadCallback(cosecha);
	}

	function cosecha(){

		HarvestService.allProduction().then(function (listHarvest) {
			
			for (var i = 0; i < listHarvest.length; i++) {
				var date = moment(listHarvest[i].date).format('LL');
				listHarvest[i].formatDate = date;
			}
			
			var data = new google.visualization.DataTable();
			data.addColumn('date', 'Fecha');
			data.addColumn('number', 'Precio ($)');
			data.addColumn('number', 'Peso (kg.)');

			data.addRows(listHarvest.length);

			for (var n = 0; n < listHarvest.length; n++) {
				var i = 0;
				for (var key in listHarvest[n]) { 	 	
					if(key === "date"){
						var datee = moment(listHarvest[n][key]);
						var dateJS = new Date(datee.year(), datee.get('month'), datee.get('date'));
						data.setValue(n, 0,   dateJS);
					}

					if(key === "price"){
						data.setValue(n, 1, listHarvest[n][key]);
					}

					if(key === "weight"){
						data.setValue(n, 2, listHarvest[n][key]);
					}
					i++;
				}
			}

			var formatter_long = new google.visualization.DateFormat({formatType: 'long'});
			
			var options = {
				chart: {
					title: 'Grafica de produccion y venta por periodo',
					subtitle: 'Produccion Gitomate'
				},
				width: 900,
				height: 500,
				 hAxis: {
					 title: "Fecha",
	                 gridlines: { count: 3, color: '#CCC' },
	                 format: 'dd MMM yyyy'
			          },
				vAxis: {
					title: "Cantidad",
					format: '###,###'
				}
			};

			var chart = new google.charts.Line(document.getElementById('line_chart_div'));
			chart.draw(data, google.charts.Line.convertOptions(options));

		},
		function (errResponse) {
			console.error('Error lista de producción');
		});

	}

}]);


