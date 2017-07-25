'use strict';

var App = angular.module('myApp', [ 'ui.router' ]);

App.config(function($stateProvider) {
	console.log(window.location);
	var homeState = {
		name : 'home',
		url : '/inicio',
		templateUrl : 'static/view/home.jsp'
	}

	var harvestState = {
		name : 'harvest',
		url : '/cosecha',
		templateUrl : 'static/view/harvest.jsp'
	}	

	var investmentState = {
		name : 'investment',
		url : '/investigacion',
		templateUrl : 'static/view/investment.jsp'
	}
	
	var treatmentState = {
			name : 'treatment',
			url : '/tratamiento',
			templateUrl : 'static/view/treatment.jsp'
		}

	$stateProvider.state(homeState);
	$stateProvider.state(harvestState);
	$stateProvider.state(investmentState);
	$stateProvider.state(treatmentState);
});
