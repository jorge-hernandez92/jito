package com.jorge.springmvc.controller;

import com.jorge.springmvc.dto.HarvestDto;
import com.jorge.springmvc.model.User;
import com.jorge.springmvc.service.HarvestService;
import com.jorge.springmvc.service.UserService;

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



@RestController
public class JitoRestController {

  @Autowired
  UserService userService;

  @Autowired
  HarvestService harvestService;

  private static final Logger logger = LogManager.getLogger(JitoRestController.class);

  /**
   * 
   * @param session
   * @param harvestDto
   * @return
   */
  @RequestMapping(value = "/addProduction", method = RequestMethod.POST)
  public ResponseEntity<Void> addProduction(HttpSession session,
      @RequestBody HarvestDto harvestDto) {
    logger.error(harvestDto.toString());
    User userLogin = (User) session.getAttribute("USER");
    if (userLogin != null) {
      logger.error(userLogin.toString());
      return new ResponseEntity<Void>(HttpStatus.CREATED);
    } else {
      return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
    }
  }


}
