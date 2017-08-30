package com.jorge.springmvc.dao.impl;

import com.jorge.springmvc.dao.AbstractDao;
import com.jorge.springmvc.dao.UserDao;
import com.jorge.springmvc.model.User;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("usuarioDAO")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

  @Override
  public User getUserByLoginAndPassword(String login, String password) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("username", login));
    crit.add(Restrictions.eq("password", password));
    User user = (User)crit.uniqueResult();
    return user;
  }

}
