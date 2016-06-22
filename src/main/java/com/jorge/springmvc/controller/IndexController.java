package com.jorge.springmvc	.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jorge.springmvc.model.Usuario;

@Controller
@RequestMapping("/")
public class IndexController {
	
      private static final Logger logger = LogManager.getLogger(JitoRestController.class);

	  @RequestMapping(method = RequestMethod.GET)
	    public String getIndexPage(HttpSession session) {
		  
	    	Usuario userLogin = (Usuario) session.getAttribute("USER");
	    	
	        if(userLogin != null){
	        	session.setAttribute("USER", userLogin);
	        	logger.info(session.getAttribute("USER").toString());
	        	return "jpro";
	        }
	        else{
	        	logger.error("El usuario no existe");
	        	return "index";
	        }
	    }
	  
	  @RequestMapping(value="/home", method = RequestMethod.GET)
	    public String getHome(HttpSession session) {		  
	    	Usuario userLogin = (Usuario) session.getAttribute("USER");
	    	
	        if(userLogin != null){
	        	session.setAttribute("USER", userLogin);
	        	logger.info(session.getAttribute("USER").toString());
	        	return "jpro";
	        }
	        else{
	        	logger.error("El usuario no existe");
	        	return "index";
	        } 
	    }
	  

}