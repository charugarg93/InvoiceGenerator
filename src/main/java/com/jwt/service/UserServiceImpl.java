package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.UserDAO;
import com.jwt.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;
	
	@Override
	@Transactional
	public int saveUser(User user) {
		return userDao.saveUser(user);
	}
	
	@Override
	@Transactional
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}
	
	@Override
	public List<User> getUserByEmail(String email){
		return userDao.getUserByEmail(email);
	}

}
