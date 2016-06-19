package com.jorge.springmvc	.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jorge.springmvc.model.Usuario;

@Controller
@RequestMapping("/")
public class IndexController {
	
      private static final Logger logger = LogManager.getLogger(HelloWorldRestController.class);

	  @RequestMapping(method = RequestMethod.GET)
	    public String getIndexPage() {
	        return "index";
	    }
	  
	  @RequestMapping(value="/home", method = RequestMethod.GET)
	    public String getHome(HttpSession session) {
		  return "jpro";  
	    }

}