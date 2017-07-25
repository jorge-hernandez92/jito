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
public class JitoRestController {
  
    @Autowired
    UserService userService; 
    
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

}