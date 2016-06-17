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
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
 
@RestController
public class HelloWorldRestController {
 
    @Autowired
    RegisterTService userService;  //Service which will do all data retrieval/manipulation work
    
    @Autowired
    UserService userLService; 
    
    private static Logger logger;
    
 
    
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
    public ResponseEntity<Void> createUser(HttpSession session, @RequestBody RegisterTomatoDTO user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.toString());
        
        Usuario userLogin = (Usuario) session.getAttribute("USER"); 
        
        if(userLogin != null){
        	
        	System.out.println("El usuario con sesion actual es: "+userLogin.toString());
        	
        	if (userService.isUserExist(user)) {
                System.out.println("A User with name " + user.toString() + " already exist");
                return new ResponseEntity<Void>(HttpStatus.CONFLICT);
            }
     
            userService.saveUser(user);
     
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
        
        else{
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
    }
    
    
    //-------------------LOGIN----------------------------------------------------------------
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Usuario> login(HttpSession session, @RequestBody RegisterTomatoDTO user,    UriComponentsBuilder ucBuilder) {
        //System.out.println("login  user " + user.toString());
    	configureLogger();
        
        Usuario userLogin = userLService.getUserByNameAndPassword(user.getUsername(), user.getPassword());
        
        if(userLogin != null){
        	logger.trace("mensaje trace");
        	logger.debug("mensaje debug");
        	logger.info("mensaje info");
        	logger.error("Did it again!");
        	session.setAttribute("USER", userLogin);
        	return new ResponseEntity<Usuario>(userLogin, HttpStatus.OK);
        }
        else{
        	return new ResponseEntity<Usuario>(HttpStatus.CONFLICT);
        }
        
    }
   
	private void configureLogger(){
		ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();
		builder.setStatusLevel(Level.DEBUG);
		builder.setConfigurationName("BuilderTest");
		builder.add(builder.newFilter("ThresholdFilter", Filter.Result.ACCEPT, Filter.Result.NEUTRAL)
		    .addAttribute("level", Level.DEBUG));
		AppenderComponentBuilder appenderBuilder = builder.newAppender("Stdout", "CONSOLE").addAttribute("target",
		    ConsoleAppender.Target.SYSTEM_OUT);
		appenderBuilder.add(builder.newLayout("PatternLayout")
		    .addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable"));
		appenderBuilder.add(builder.newFilter("MarkerFilter", Filter.Result.DENY, Filter.Result.NEUTRAL)
		    .addAttribute("marker", "FLOW"));
		builder.add(appenderBuilder);
		builder.add(builder.newLogger("org.apache.logging.log4j", Level.DEBUG)
		    .add(builder.newAppenderRef("Stdout")).addAttribute("additivity", false));
		builder.add(builder.newRootLogger(Level.DEBUG).add(builder.newAppenderRef("Stdout")));
		LoggerContext ctx = Configurator.initialize(builder.build());
		logger = ctx.getLogger(HelloWorldRestController.class.getName());
		
	}
 
}