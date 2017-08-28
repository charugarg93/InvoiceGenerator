package com.jwt.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.UserDAO;
import com.jwt.model.User;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserDAO userDao;
	
	@Override
	@Transactional
	public int saveUser(User user) {
		log.debug("Adding user for email: "+ user.getEmail());
		return userDao.saveUser(user);
	}
	
	@Override
	@Transactional
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}
	
	@Override
	@Transactional
	public List<User> getUserByEmail(String email){
		log.debug("Fetching user id for email: " + email);
		return userDao.getUserByEmail(email);
	}

}
