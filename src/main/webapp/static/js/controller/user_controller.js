'use strict';
 
App.controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
          var self = this;
          self.users=[];
           
          
          self.login = function(user){
        	  UserService.getSingleUser(user)
        	  		.then(
        	  				function(d) {
        	  					self.userLogin = d;
        	  				},
        	  				function(errResponse){
        	  					console.error('error login');
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
        	  
        	  self.login(self.user)
          }
          
          
          self.reset = function(){
              self.user={id:null,username:'',address:'',email:''};
              $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);
