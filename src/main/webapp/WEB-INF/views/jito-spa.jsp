<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>JPro</title>  
     <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
     <link href="<c:url value='/static/css/bootstrap-datetimepicker.css' />" rel="stylesheet"></link>
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
            <li ui-sref-active="active"><a href="" ui-sref="harvest" >Registro de Cosecha</a></li>
            <li ui-sref-active="active"><a href="" ui-sref="treatment">Tratamiento</a></li>
            <li ui-sref-active="active"><a href="" ui-sref="investment">Inversi�n</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a ng-click="ctrl.btnLogout()">Cerrar sessi�n</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>    
	<div style="padding-left: 150px;padding-right: 150px;">
		<ui-view></ui-view>	
	</div>
	<script src="<c:url value='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js' />"></script>
	<script src="//unpkg.com/angular-ui-router/release/angular-ui-router.min.js"></script>
    <script src="<c:url value='/static/js/library/angular-resource.js' />"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/service/user_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
  </body>
</html>