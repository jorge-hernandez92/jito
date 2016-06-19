'use strict';
 
App.controller('LoginController', ['$scope', 'UserService', function($scope, UserService) {
          var self = this;
          self.users=[];
           
          
          self.login = function(user){
        	  UserService.login(user)
        	  		.then(
        	  				function(d) {
        	  					self.userLogin = d;
        	  					window.location.href= "home";
        	  				},
        	  				function(errResponse){
        	  					console.error('ERROR CON EL USUARIO');
        	  				}
        	  		);
          }
 
          self.submit = function() {
        	  self.login(self.user)
          };
 
      }]);
