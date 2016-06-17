package com.jorge.springmvc.service;

import com.jorge.springmvc.model.Usuario;

public interface UserService {
	
	public Usuario getUserByNameAndPassword(String user, String password);

}
