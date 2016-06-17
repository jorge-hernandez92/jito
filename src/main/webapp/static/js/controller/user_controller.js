'use strict';
 
App.controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
          var self = this;
          self.users=[];
           
          
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
               
          self.fetchAllUsers = function(){
              UserService.fetchAllUsers()
                  .then(
                               function(d) {
                                    self.users = d;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
            
          self.createUser = function(user){
              UserService.createUser(user)
                      .then(
                      self.fetchAllUsers, 
                              function(errResponse){
                                   console.error('Error while creating User.');
                              } 
                  );
          };
 
          self.fetchAllUsers();
 
          self.submit = function() {
        	  console.log('Saving New User', self.user);
        	  self.createUser(self.user);
        	  
              self.reset();
          };
          
          self.btnLogin = function() {
        	  console.log("boton de login", self.user)
        	  self.login(self.user)
        	  console.log("Usuario actual: ",self.userLogin);
          }
          
          
          self.reset = function(){
              self.user={id:null,username:'',address:'',email:''};
              $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);
