<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>JPro</title>  
     <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
     <link href="<c:url value='/static/css/font-awesome.min.css' />" rel="stylesheet"></link>
     
      <!-- AngularJS Material CSS now available via Google CDN; version 1.1.4 used here -->
   <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.4/angular-material.min.css">
  </head>
  <body ng-app="myApp" class="ng-cloak" ng-controller="UserController as ctrl" >  
  <nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Jito</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li ui-sref-active="active"><a href="" ui-sref="home" >Inicio</a></li>
            <li ui-sref-active="active"><a href="" ui-sref="harvest" >Cosecha</a></li>
            <li ui-sref-active="active"><a href="" ui-sref="treatment">Tratamiento</a></li>
            <li ui-sref-active="active"><a href="" ui-sref="diseases">Enfermedades</a></li>
            <li ui-sref-active="active"><a href="" ui-sref="investment">Inversión</a></li>
            <li ui-sref-active="active"><a href="" ui-sref="plant">Planta</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="" ng-click="ctrl.btnLogout()">Cerrar sessión</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>    
	<div style="padding-left: 150px;padding-right: 150px;">
		<ui-view></ui-view>	
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
  	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script>

     <!-- AngularJS Material Javascript now available via Google CDN; version 1.1.4 used here -->
    <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.4/angular-material.min.js"></script>
    
    <script src="https://unpkg.com/angular-ui-router/release/angular-ui-router.min.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/service/user_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>    
    
    <script src="<c:url value='/static/js/libraries/moment.min.js' />"></script>
    <script src="<c:url value='/static/js/libraries/es.js' />"></script>
    <script src="<c:url value='/static/js/libraries/angular-moment.min.js' />"></script>    
    
  </body>
</html>