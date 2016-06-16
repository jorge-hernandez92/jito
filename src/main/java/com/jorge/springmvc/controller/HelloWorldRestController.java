package com.jorge.springmvc.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jorge.springmvc.dto.RegisterTomatoDTO;
import com.jorge.springmvc.service.RegisterTService;
 
@RestController
public class HelloWorldRestController {
 
    @Autowired
    RegisterTService userService;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<RegisterTomatoDTO>> listAllUsers() {
        List<RegisterTomatoDTO> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<RegisterTomatoDTO>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<RegisterTomatoDTO>>(users, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisterTomatoDTO> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        RegisterTomatoDTO user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<RegisterTomatoDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<RegisterTomatoDTO>(user, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody RegisterTomatoDTO user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.toString());
        
 
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.toString() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RegisterTomatoDTO> updateUser(@PathVariable("id") long id, @RequestBody RegisterTomatoDTO user) {
        System.out.println("Updating User " + id);
         
        RegisterTomatoDTO currentUser = userService.findById(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<RegisterTomatoDTO>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setUsername(user.getUsername());
         
        userService.updateUser(currentUser);
        return new ResponseEntity<RegisterTomatoDTO>(currentUser, HttpStatus.OK);
    }
 
}