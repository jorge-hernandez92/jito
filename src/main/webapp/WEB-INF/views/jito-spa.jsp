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
            <li class="active"><a href="#">Inicio</a></li>
            <li><a href="">Registro de Cosecha</a></li>
            <li><a href="">Tratamiento</a></li>
            <li><a href="">Inversión</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a ng-click="ctrl.btnLogout()">Cerrar sessión</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
      <script src="<c:url value='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js' />"></script>
      <script src="<c:url value='/static/js/library/angular-resource.js' />"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/user_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
  </body>
</html>