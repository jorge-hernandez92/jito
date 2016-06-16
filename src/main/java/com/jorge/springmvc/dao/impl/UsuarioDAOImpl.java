package com.jorge.springmvc.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jorge.springmvc.dao.AbstractDAO;
import com.jorge.springmvc.dao.UsuarioDAO;
import com.jorge.springmvc.model.Usuario;

@Repository("usuarioDAO")
public class UsuarioDAOImpl extends AbstractDAO<Integer, Usuario> implements UsuarioDAO{

	@Override
	public Usuario getUserByLoginAndPassword(String login, String password) {
		
		Criteria crit = createEntityCriteria()
		.add(Restrictions.eq("login", login))
		.add(Restrictions.eq("password", password));
		
		return (Usuario)crit.uniqueResult();
	}

}
