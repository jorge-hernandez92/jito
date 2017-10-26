<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="myApp">
  <head>  
    <title>Jito</title>  
    
     <link href="<c:url value='/static/css/font-awesome.min.css' />" rel="stylesheet"></link>
     <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
     
   	<link href="<c:url value='/static/css/angular-material.css' />" rel="stylesheet"></link>
   	
   	
   	
   	<link href="<c:url value='/static/css/angular-datatables.min.css' />" rel="stylesheet"></link>
   	<link href="<c:url value='/static/css/dataTables.bootstrap4.min.css' />" rel="stylesheet"></link>
   	
  </head>
  <body  class="ng-cloak" >
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" ng-controller="SessionController as ctrlSession">
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
					class="nav-link" href="" ui-sref="harvest2">Cosecha V2</a></li>
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
					ng-click="ctrlSession.btnLogout()">Cerrar Sesión</button>
			</form>
		</div>
	</nav>

	<div style="padding-left: 150px;padding-right: 150px;padding-top: 5rem;background-color: white;">
		<ui-view></ui-view>	
	</div>
    
    <script src="<c:url value='/static/js/libraries/loader.js' />"></script>
    <script src="<c:url value='/static/js/libraries/angular.min.js' />"></script>
    <script src="<c:url value='/static/js/libraries/angular-animate.min.js' />"></script>
    <script src="<c:url value='/static/js/libraries/angular-aria.min.js' />"></script>
    <script src="<c:url value='/static/js/libraries/angular-messages.min.js' />"></script>
    


    <script src="<c:url value='/static/js/libraries/angular-material.min.js' />"></script>
    <script src="<c:url value='/static/js/libraries/angular-ui-router.min.js' />"></script>
    <script src="<c:url value='/static/js/libraries/jquery-3.2.1.slim.min.js' />"></script>
    <script src="<c:url value='/static/js/libraries/moment.min.js' />"></script>
    <script src="<c:url value='/static/js/libraries/es.js' />"></script>
    <script src="<c:url value='/static/js/libraries/angular-moment.min.js' />"></script>  
    <script src="<c:url value='/static/js/libraries/bootstrap-datetimepicker.min.js' />"></script>
    <script src="<c:url value='/static/js/libraries/angular-bootstrap-datetimepicker-directive.js' />"></script>
    
    
    
    
    <script src="<c:url value='/static/js/libraries/jquery.dataTables.min.js' />"></script>
    <script src="<c:url value='/static/js/libraries/angular-datatables.min.js' />"></script>
    <script src="<c:url value='/static/js/libraries/dataTables.bootstrap4.min.js' />"></script>
    
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/service/session_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/session_controller.js' />"></script>
    <script src="<c:url value='/static/js/controller/harvest_controller.js' />"></script>  
    <script src="<c:url value='/static/js/controller/harvest2_controller.js' />"></script>  
    <script src="<c:url value='/static/js/controller/chart_controller.js' />"></script>  
    <script src="<c:url value='/static/js/service/harvest_service.js' />"></script>
       

	<script src="<c:url value='/static/js/libraries/popper.min.js' />"></script>
	<script src="<c:url value='/static/js/libraries/bootstrap.min.js' />"></script>
	
    
  </body>
</html>