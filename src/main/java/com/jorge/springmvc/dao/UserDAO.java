package com.jorge.springmvc.dao;

import com.jorge.springmvc.model.User;

public interface UserDAO {
	
	User getUserByLoginAndPassword(String login, String password);

}
