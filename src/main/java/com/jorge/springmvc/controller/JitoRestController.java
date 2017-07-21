package com.jorge.springmvc.controller;
 
import java.util.List;

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
import org.springframework.web.util.UriComponentsBuilder;

import com.jorge.springmvc.dto.ProductionDTO;
import com.jorge.springmvc.model.Usuario;
import com.jorge.springmvc.service.UserService;
 
@RestController
public class JitoRestController {
 
//    @Autowired
//    RegisterTService userService; 
//    
    @Autowired
    UserService userLService; 
    
    
    private static final Logger logger = LogManager.getLogger(JitoRestController.class);
 
 
    
//    @RequestMapping(value = "/production", method = RequestMethod.GET)
//    public ResponseEntity<List<ProductionDTO>> listAllProduction() {
//        List<ProductionDTO> users = userService.findAllProduction();
//        if(users.isEmpty()){
//            return new ResponseEntity<List<ProductionDTO>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<ProductionDTO>>(users, HttpStatus.OK);
//    }
//    
//    
//    
//    /*
//     * Add tomatoes production
//     */
//    @RequestMapping(value = "/addTomatoes", method = RequestMethod.POST)
//    public ResponseEntity<Void> AddTomatoesPro(HttpSession session, @RequestBody Produccion production,    UriComponentsBuilder ucBuilder) {        
//        Usuario userLogin = (Usuario) session.getAttribute("USER"); 
//        
//        if(userLogin != null){
//        	
//        	userService.saveProduction(production, userLogin.getIdUsuario());
//            return new ResponseEntity<Void>(HttpStatus.CREATED);
//        }
//        
//        else{
//        	return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
//        }
//        
//    }
//    
    /*
     * Create a session for the user when it is login.  
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Usuario> login(HttpSession session, @RequestBody Usuario user) {
        
        Usuario userLogin = userLService.getUserByNameAndPassword(user.getLogin(), user.getPassword());
        
        logger.info("Quiere iniciar sesion el usuario: "+user.toString());
        
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