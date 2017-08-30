package com.jorge.springmvc.service.impl;

import com.jorge.springmvc.dao.UserDao;
import com.jorge.springmvc.model.User;
import com.jorge.springmvc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImp implements UserService {

  @Autowired
  UserDao userDao;

  @Override
  public User getUserByNameAndPassword(String userName, String password) {
    User user = userDao.getUserByLoginAndPassword(userName, password);
    return user;
  }

}
