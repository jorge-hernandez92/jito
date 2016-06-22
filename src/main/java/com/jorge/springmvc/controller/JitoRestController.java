package com.jorge.springmvc.controller;
 
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jorge.springmvc.dto.RegisterTomatoDTO;
import com.jorge.springmvc.model.Usuario;
import com.jorge.springmvc.service.RegisterTService;
import com.jorge.springmvc.service.UserService;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
 
@RestController
public class JitoRestController {
 
    @Autowired
    RegisterTService userService;  //Service which will do all data retrieval/manipulation work
    
    @Autowired
    UserService userLService; 
    
    //private static Logger logger;
    private static final Logger logger = LogManager.getLogger(JitoRestController.class);
 
    
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<RegisterTomatoDTO>> listAllUsers() {
        List<RegisterTomatoDTO> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<RegisterTomatoDTO>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<RegisterTomatoDTO>>(users, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(HttpSession session, @RequestBody RegisterTomatoDTO user, UriComponentsBuilder ucBuilder) {
        
        Usuario userLogin = (Usuario) session.getAttribute("USER"); 
        
        if(userLogin != null){
     
            userService.saveUser(user, userLogin.getIdUsuario());
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        
        else{
        	return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        }
        
    }
    
    /*
     * Add tomatoes production
     */
    @RequestMapping(value = "/addTomatoes", method = RequestMethod.POST)
    public ResponseEntity<Void> AddTomatoesPro(HttpSession session, @RequestBody RegisterTomatoDTO user,    UriComponentsBuilder ucBuilder) {        
        Usuario userLogin = (Usuario) session.getAttribute("USER"); 
        
        if(userLogin != null){
     
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        
        else{
        	return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        }
        
    }
    
    /*
     * Create a session for the user when it is login.  
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Usuario> login(HttpSession session, @RequestBody RegisterTomatoDTO user) {
        
        Usuario userLogin = userLService.getUserByNameAndPassword(user.getUsername(), user.getPassword());
        
        if(userLogin != null){
        	session.setAttribute("USER", userLogin);
        	logger.info(session.getAttribute("USER").toString());
        	return new ResponseEntity<Usuario>(userLogin, HttpStatus.OK);
        }
        else{
        	logger.error("El usuario no existe");
        	return new ResponseEntity<Usuario>(HttpStatus.UNAUTHORIZED);
        }
        
    }
    
    /*
     * verify if exist a session
     */
    @RequestMapping(value = "/checkSession", method = RequestMethod.POST)
    public ResponseEntity<Usuario> login(HttpSession session) {
        
    	Usuario userLogin = (Usuario) session.getAttribute("USER");
    	
        if(userLogin != null){
        	session.setAttribute("USER", userLogin);
        	logger.info(session.getAttribute("USER").toString());
        	return new ResponseEntity<Usuario>(userLogin, HttpStatus.OK);
        }
        else{
        	logger.error("El usuario no existe");
        	return new ResponseEntity<Usuario>(HttpStatus.UNAUTHORIZED);
        }
    }
 
}