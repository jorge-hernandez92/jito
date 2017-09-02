<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Jito</title>  
    
     <link href="<c:url value='/static/css/font-awesome.min.css' />" rel="stylesheet"></link>
     <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
     
      <!-- AngularJS Material CSS now available via Google CDN; version 1.1.4 used here -->
   	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.4/angular-material.min.css">
   	
  </head>
  <body ng-app="myApp" class="ng-cloak" ng-controller="UserController as ctrl" >
	<nav class="navbar navbar-expand-lg navbar-light fixed-top bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="#">J I T O M</a>

		<div class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item" ui-sref-active="active"><a
					class="nav-link" href="" ui-sref="home">Inicio</a></li>
				<li class="nav-item" ui-sref-active="active"><a
					class="nav-link" href="" ui-sref="harvest">Cosecha</a></li>
				<li class="nav-item" ui-sref-active="active"><a
					class="nav-link" href="" ui-sref="treatment">Tratamiento</a></li>
				<li class="nav-item" ui-sref-active="active"><a
					class="nav-link" href="" ui-sref="diseases">Enfermedades</a></li>
				<li class="nav-item" ui-sref-active="active"><a
					class="nav-link" href="" ui-sref="investment">Inversión</a></li>
				<li class="nav-item" ui-sref-active="active"><a
					class="nav-link" href="" ui-sref="plant">Planta</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<button type="button" class="btn btn-outline-secondary my-2 my-sm-0"
					ng-click="ctrl.btnLogout()">Cerrar Sesión</button>
			</form>
		</div>
	</nav>

	<div style="padding-left: 150px;padding-right: 150px;padding-top: 5rem;">
		<ui-view></ui-view>	
	</div>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
  	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script>

     <!-- AngularJS Material Javascript now available via Google CDN; version 1.1.4 used here -->
    <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.4/angular-material.min.js"></script>
    
    <script src="https://unpkg.com/angular-ui-router/release/angular-ui-router.min.js"></script>
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    
    <script src="<c:url value='/static/js/libraries/moment.min.js' />"></script>
    <script src="<c:url value='/static/js/libraries/es.js' />"></script>
    <script src="<c:url value='/static/js/libraries/angular-moment.min.js' />"></script>  
    
    <script src="<c:url value='/static/js/libraries/bootstrap-datetimepicker.min.js' />"></script>
    <script src="<c:url value='/static/js/libraries/angular-bootstrap-datetimepicker-directive.js' />"></script>
    
    
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/service/user_service.js' />"></script>
    <script src="<c:url value='/static/js/service/harvest_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>    
    
    
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script> 
    
  </body>
</html>