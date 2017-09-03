<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Inicio de sesión</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>

    <!-- Custom styles for this template -->
    
    <link href="<c:url value='/static/css/signin.css' />" rel="stylesheet"></link>

  </head>	
  <body ng-app="myAppL" class="ng-cloak">
    
<!--     <div class="wrapper" ng-controller="LoginController as ctrl"> -->
<!--       <form ng-submit="ctrl.login()" class="form-signin" > -->
<!--         <h2 class="form-signin-heading">Inicio de Sesión</h2> -->
<!--         <label for="inputEmail" class="sr-only">Nombre de Usuario</label> -->
<!--         <input ng-model="ctrl.user.username" id="inputEmail" class="form-control" placeholder="Nombre de Usuario" required autofocus> -->
<!--         <label for="inputPassword" class="sr-only">Contraseña</label> -->
<!--         <input ng-model="ctrl.user.password" type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required> -->
<!--         <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar Sesión</button> -->
<!--       </form> -->
<!--     </div>  -->


<div class="wrapper" ng-controller="LoginController as ctrl">
  <form ng-submit="ctrl.login()" class="form-signin">
  <h2 class="form-signin-heading" style="text-align: center;">J I T O </h2>
    <div class="form-group row">
      <label for="inputEmail3" class="col-sm-3 col-form-label">Usuario</label>
      <div class="col-sm-9">
        <input ng-model="ctrl.user.username" type="text" class="form-control"  placeholder="Usuario" required autofocus>
      </div>
    </div>
    <div class="form-group row">
      <label for="inputPassword3" class="col-sm-3 col-form-label">Contraseña</label>
      <div class="col-sm-9">
        <input ng-model="ctrl.user.password" type="password" class="form-control"  placeholder="Contraseña" required>
      </div>
    </div>
    <div class="form-group row">
      <div class="offset-sm-2 col-sm-12" style="text-align: center;">
        <button type="submit" class="btn btn-primary">Entrar</button>
      </div>
    </div>
  </form>
</div>
    
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
<!--   	  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script> -->
<!--       <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js"></script> -->
<!--       <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script> -->

<!--      Angular Material Library -->
<!--       <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.4/angular-material.min.js"></script> -->
<!--       <script src="https://unpkg.com/angular-ui-router/release/angular-ui-router.min.js"></script> -->
      
      
<%--       <script src="<c:url value='/static/js/libraries/angular-bootstrap-datetimepicker-directive.js' />"></script> --%>
      
      
<%--       <script src="<c:url value='/static/js/app.js' />"></script> --%>
      
      <script src="<c:url value='/static/js/controller/login_controller.js' />"></script>
      <script src="<c:url value='/static/js/service/login_service.js' />"></script>
<%--       <script src="<c:url value='/static/js/libraries/moment.min.js' />"></script> --%>
<%--       <script src="<c:url value='/static/js/libraries/es.js' />"></script> --%>
<%--       <script src="<c:url value='/static/js/libraries/angular-moment.min.js' />"></script>  --%>
      
  </body>
</html>