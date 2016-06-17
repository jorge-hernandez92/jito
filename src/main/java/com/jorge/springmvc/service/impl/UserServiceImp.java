package com.jorge.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jorge.springmvc.dao.UserDAO;
import com.jorge.springmvc.model.Usuario;
import com.jorge.springmvc.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImp implements UserService {
	
	@Autowired
	UserDAO userDAO; 

	@Override
	public Usuario getUserByNameAndPassword(String userName, String password) {
		
		Usuario user = userDAO.getUserByLoginAndPassword(userName, password);
		
		if(user == null){
			//LOG
		}
		
		return user;
	}

}
