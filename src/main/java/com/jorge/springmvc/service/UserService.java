package com.jorge.springmvc.service;

import com.jorge.springmvc.model.User;

public interface UserService {
	
	public User getUserByNameAndPassword(String user, String password);

}
