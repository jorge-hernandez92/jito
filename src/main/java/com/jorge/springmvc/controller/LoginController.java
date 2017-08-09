package com.jorge.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.springmvc.model.User;
import com.jorge.springmvc.service.UserService;
 
@RestController
public class LoginController {
  
    @Autowired
    UserService userService; 
    
    private static final Logger logger = LogManager.getLogger(LoginController.class);
    
    /**
     * Create a session for the user when it is login.
     * @param session
     * @param user
     * @return status of request
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(HttpSession session, @RequestBody User user) {
        User userLogin = userService.getUserByNameAndPassword(user.getUsername(), user.getPassword());
        logger.info("Quiere iniciar sesion el usuario: "+user.toString());
        if(userLogin != null){
        	session.setAttribute("USER", userLogin);
        	logger.info(session.getAttribute("USER").toString());
        	return new ResponseEntity<User>(userLogin, HttpStatus.OK);
        }
        else{
        	logger.error("El usuario no existe");
        	return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
        }
    }
    
    /**
     * verify if exist a session
     * @param session petición 
     * @return status of request
     */
    @RequestMapping(value = "/checkSession", method = RequestMethod.POST)
    public ResponseEntity<User> login(HttpSession session) {
    	User userLogin = (User) session.getAttribute("USER");
        if(userLogin != null){
        	session.setAttribute("USER", userLogin);
        	logger.info(session.getAttribute("USER").toString());
        	return new ResponseEntity<User>(userLogin, HttpStatus.OK);
        }
        else{
        	logger.error("El usuario no existe");
        	return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
        }
    }
    
    /**
     * Close session
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity<User> logout(HttpSession session) {
    	User userLogin = (User) session.getAttribute("USER");
    	logger.error("cerrando sesión");
        if(userLogin != null){
        	session.invalidate();
        	return new ResponseEntity<User>(HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }   
    }
}