package com.jorge.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jorge.springmvc.model.User;

@Controller
@RequestMapping("/")
public class IndexController {

	private static final Logger logger = LogManager
			.getLogger(JitoRestController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage(HttpSession session) {
		User userLogin = (User) session.getAttribute("USER");
		if (userLogin != null) {
			session.setAttribute("USER", userLogin);
			logger.info(session.getAttribute("USER").toString());
			return "jito-spa";
		} else {
			logger.error("El usuario no existe");
			return "login";
		}
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome(HttpSession session) {
		User userLogin = (User) session.getAttribute("USER");
		if (userLogin != null) {
			session.setAttribute("USER", userLogin);
			logger.info(session.getAttribute("USER").toString());
			return "jito-spa";
		} else {
			logger.error("El usuario no existe");
			return "login";
		}
	}
}