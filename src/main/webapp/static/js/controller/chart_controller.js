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
			// for (var n = 0; n < $scope.listHarvest.length; n++) {
			// 	var i = 0;
			// 	for (var key in $scope.listHarvest[n]) {
			// 		console.log(n + "," + i + "->" + key + "=" + $scope.listHarvest[n][key])
			// 		i++;
			// 	}
			// }
			// google.charts.load('current', { 'packages': ['line'] });
			// 


			google.charts.load('current', { 'packages': ['line'] });
			//google.charts.setOnLoadCallback(drawChartLine);
			google.charts.setOnLoadCallback(cosecha);

		},
			function (errResponse) {
				console.error('Error lista de producción');
			});
	};


	function cosecha(){

		var data = new google.visualization.DataTable();
		data.addColumn('date', 'Fecha');
		data.addColumn('number', 'Precio');
		data.addColumn('number', 'Peso');

		data.addRows(listaCose.length);

		for (var n = 0; n < listaCose.length; n++) {
			var i = 0;
			for (var key in listaCose[n]) { 	 	
//				if(key === "idHarvest"){
//					data.setValue(n, 0, listaCose[n][key]);
//					console.log(n + "," + i + "->" + key + "=" + listaCose[n][key]);
//				}
				if(key === "date"){
					var datee = moment(listaCose[n][key]);
					console.log(datee);
					console.log('Dia: '+datee.get('date'));
					console.log('Mes: '+datee.get('month'));
					console.log('Year: '+datee.get('year'));
					var dateJS = new Date(datee.year(), datee.get('month'), datee.get('date'));
					console.log(dateJS);
					//data.setValue(n, 0,   moment(listaCose[n][key]).format('YYYY-MM-DD'));
					data.setValue(n, 0,   dateJS);
					//console.log(n + "," + i + "->" + key + "=" + listaCose[n][key]);
					
					
				}

				if(key === "price"){
					data.setValue(n, 1, listaCose[n][key]);
					//console.log(n + "," + i + "->" + key + "=" + listaCose[n][key]);
				}

				if(key === "weight"){
					data.setValue(n, 2, listaCose[n][key]);
					console.log(n + "," + i + "->" + key + "=" + listaCose[n][key]);
				}



				//console.log(n + "," + i + "->" + key + "=" + listHarvest[n][key]);
				i++;
			}
		}

		var options = {
			chart: {
				title: 'Box Office Earnings in First Two Weeks of Opening',
				subtitle: 'in millions of dollars (USD)'
			},
			width: 900,
			height: 500
		};

		var chart = new google.charts.Line(document.getElementById('line_chart_div'));

		chart.draw(data, google.charts.Line.convertOptions(options));

	}
	

	function drawChartLine() {

		

		var data = new google.visualization.DataTable();
		data.addColumn('number', 'Day');
		data.addColumn('number', 'Precio');
		data.addColumn('number', 'Peso');

		data.addRows([
			[1, 37.8, 80.8],
			[2, 30.9, 69.5],
			[3, 25.4, 57],
			[4, 11.7, 18.8],
			[5, 11.9, 17.6],
			[6, 8.8, 13.6],
			[7, 7.6, 12.3],
			[8, 12.3, 29.2],
			[9, 16.9, 42.9],
			[10, 12.8, 30.9],
			[11, 5.3, 7.9],
			[12, 6.6, 8.4],
			[13, 4.8, 6.3],
			[14, 4.2, 6.2]
		]);

		var options = {
			chart: {
				title: 'Box Office Earnings in First Two Weeks of Opening',
				subtitle: 'in millions of dollars (USD)'
			},
			width: 900,
			height: 500
		};

		var chart = new google.charts.Line(document.getElementById('line_chart_div'));

		chart.draw(data, google.charts.Line.convertOptions(options));



		
	}


}]);


