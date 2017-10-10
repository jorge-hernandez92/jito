'use strict';

App.controller('ChartController', ['$scope', 'HarvestService', function ($scope, HarvestService) {
	var self = this;
	var listaCose; 
	$scope.users = [];

	$scope.allProduction = allProduction;

	allProduction();

	function allProduction() {
		HarvestService.allProduction().then(function (d) {
			for (var i = 0; i < d.length; i++) {
				var date = moment(d[i].date).format('LL');
				d[i].formatDate = date;
			}
			$scope.listHarvest = d;
			console.log($scope.listHarvest);

			listaCose = $scope.listHarvest; 
			google.charts.load('current', { 'packages': ['line'], 'language': 'es'});
			google.charts.setOnLoadCallback(cosecha);

		},
			function (errResponse) {
				console.error('Error lista de producción');
			});
	};


	function cosecha(){

		var data = new google.visualization.DataTable();
		data.addColumn('date', 'Fecha');
		data.addColumn('number', 'Precio ($)');
		data.addColumn('number', 'Peso (kg.)');

		data.addRows(listaCose.length);

		for (var n = 0; n < listaCose.length; n++) {
			var i = 0;
			for (var key in listaCose[n]) { 	 	
				if(key === "date"){
					var datee = moment(listaCose[n][key]);
					console.log(datee);
					console.log('Dia: '+datee.get('date'));
					console.log('Mes: '+datee.get('month'));
					console.log('Year: '+datee.get('year'));
					var dateJS = new Date(datee.year(), datee.get('month'), datee.get('date'));
					console.log(dateJS);
					data.setValue(n, 0,   dateJS);
				}

				if(key === "price"){
					data.setValue(n, 1, listaCose[n][key]);
				}

				if(key === "weight"){
					data.setValue(n, 2, listaCose[n][key]);
					console.log(n + "," + i + "->" + key + "=" + listaCose[n][key]);
				}
				i++;
			}
		}

		var formatter_long = new google.visualization.DateFormat({formatType: 'long'});
		
		var options = {
			chart: {
				title: 'Grafica de produccion y venta por periodo',
				subtitle: 'Producciom Gitomate'
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

	}

}]);


