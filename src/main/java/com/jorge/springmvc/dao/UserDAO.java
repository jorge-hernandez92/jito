package com.jorge.springmvc.dao;

import com.jorge.springmvc.model.Usuario;

public interface UserDAO {
	
	Usuario getUserByLoginAndPassword(String login, String password);

}
