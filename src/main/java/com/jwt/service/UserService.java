package com.jwt.service;

import java.util.List;

import com.jwt.model.User;

public interface UserService {
	int saveUser(User user);

	User updateUser(User user);

	List<User> getUserByEmail(String email);
}
