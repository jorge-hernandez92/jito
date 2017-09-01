'use strict';

var App = angular.module('myApp', ['ui.router', 'ngMaterial', 'ngMessages', 'angularMoment']);

App.run(function (amMoment) {
	amMoment.changeLocale('es');
});

App.config(function ($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/inicio');

	var homeState = {
		name: 'home',
		url: '/inicio',
		templateUrl: 'static/view/home.jsp'
	}

	var harvestState = {
		name: 'harvest',
		url: '/cosecha',
		templateUrl: 'static/view/harvest.jsp'
	}

	var investmentState = {
		name: 'investment',
		url: '/investigacion',
		templateUrl: 'static/view/investment.jsp'
	}

	var treatmentState = {
		name: 'treatment',
		url: '/tratamiento',
		templateUrl: 'static/view/treatment.jsp'
	}

	var diseasesState = {
		name: 'diseases',
		url: '/enfermedades',
		templateUrl: 'static/view/diseases.jsp'
	}

	var plantState = {
		name: 'plant',
		url: '/planta',
		templateUrl: 'static/view/plant.jsp'
	}

	$stateProvider.state(homeState);
	$stateProvider.state(harvestState);
	$stateProvider.state(investmentState);
	$stateProvider.state(treatmentState);
	$stateProvider.state(diseasesState);
	$stateProvider.state(plantState);
});

App.config(function ($mdDateLocaleProvider) {
	// Example of a Spanish localization.
	$mdDateLocaleProvider.months = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
		'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
	$mdDateLocaleProvider.shortMonths = ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
		'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'];
	$mdDateLocaleProvider.days = ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado'];
	$mdDateLocaleProvider.shortDays = ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'];
	// Can change week display to start on Monday.
	$mdDateLocaleProvider.firstDayOfWeek = 1;
	// Optional.
	//$mdDateLocaleProvider.dates = [1, 2, 3, 4, 5, 6, 7,8,9,10,11,12,13,14,15,16,17,18,19,
	//                               20,21,22,23,24,25,26,27,28,29,30,31];
	// In addition to date display, date components also need localized messages
	// for aria-labels for screen-reader users.
	$mdDateLocaleProvider.weekNumberFormatter = function (weekNumber) {
		return 'Semana ' + weekNumber;
	};
	$mdDateLocaleProvider.msgCalendar = 'Calendario';
	$mdDateLocaleProvider.msgOpenCalendar = 'Abrir calendario';
});
