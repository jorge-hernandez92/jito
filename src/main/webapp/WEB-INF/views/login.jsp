<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Inicio de sesión</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>

    <!-- Custom styles for this template -->
    
    <link href="<c:url value='/static/css/signin.css' />" rel="stylesheet"></link>

  </head>	
  <body ng-app="myApp" class="ng-cloak">
    <div class="container" ng-controller="LoginController as ctrl">
      <form ng-submit="ctrl.login()" class="form-signin" >
        <h2 class="form-signin-heading">Inicio de Sesión</h2>
        <label for="inputEmail" class="sr-only">Nombre de Usuario</label>
        <input ng-model="ctrl.user.username" id="inputEmail" class="form-control" placeholder="Nombre de Usuario" required autofocus>
        <label for="inputPassword" class="sr-only">Contraseña</label>
        <input ng-model="ctrl.user.password" type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar Sesión</button>
      </form>
    </div> <!-- /container -->
    
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
  	  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script>

     <!-- Angular Material Library -->
      <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.js"></script>
      <script src="https://unpkg.com/angular-ui-router/release/angular-ui-router.min.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/user_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/login_controller.js' />"></script>
      
      
      
  </body>
</html>