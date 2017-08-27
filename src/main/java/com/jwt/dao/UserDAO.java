package com.jwt.dao;

import java.util.List;

import com.jwt.model.User;

public interface UserDAO {
	int saveUser(User user);

	User updateUser(User user);

	List<User> getUserByEmail(String email);

}
