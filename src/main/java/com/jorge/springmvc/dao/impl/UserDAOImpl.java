package com.jorge.springmvc.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jorge.springmvc.dao.AbstractDAO;
import com.jorge.springmvc.dao.UserDAO;
import com.jorge.springmvc.model.User;

@Repository("usuarioDAO")
public class UserDAOImpl extends AbstractDAO<Integer, User> implements UserDAO{

	@Override
	public User getUserByLoginAndPassword(String login, String password) {
		Criteria crit = createEntityCriteria()
		.add(Restrictions.eq("username", login))
		.add(Restrictions.eq("password", password));
		return (User)crit.uniqueResult();
	}

}
