package com.jorge.springmvc.dao;

import com.jorge.springmvc.model.Usuario;

public interface UsuarioDAO {
	
	Usuario getUserByLoginAndPassword(String login, String password);

}
