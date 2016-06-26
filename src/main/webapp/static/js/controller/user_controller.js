'use strict';
 
App.controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
          var self = this;
          self.users=[];
          self.date = new Date();
          
          $scope.example = {
        	         value: new Date()
          };
          
          
          self.login = function(user){
        	  UserService.login(user)
        	  		.then(
        	  				function(d) {
        	  					self.userLogin = d;
        	  				},
        	  				function(errResponse){
        	  					console.error('ERROR CON EL USUARIO');
        	  				}
        	  		);
          }
               
          self.fetchAllProduction = function(){
              UserService.fetchAllProduction()
                  .then(
                               function(d) {
                                    self.users = d;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
            
          self.addProduction = function(user){
              UserService.addProduction(user)
                      .then(
                      self.fetchAllProduction, 
                              function(errResponse){
                                   console.error('Error while creating User.');
                              } 
                  );
          };
 
          self.fetchAllProduction();
 
          self.submit = function() {
        	  
        	  self.user.date = $scope.example.value;
        	  console.log('Saving New User', self.user);
        	  self.addProduction(self.user);
        	  console.log($scope.example.value);
              self.reset();
          };
          
          self.reset = function(){
              self.user={};
              $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);
