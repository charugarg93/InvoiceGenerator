package com.jwt.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.jwt.model.User;

public class TestUserDAO {
	@Mock
	private UserDAO userDao;
	@Mock
	private User user;
	@Mock
	private List<User> users;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testMockCreationOfUserDao(){
		assertNotNull(user);
		assertNotNull(userDao);
	}

	@Test
	public void testSaveUser(){
		when(userDao.saveUser(user)).thenReturn(1);
		assertEquals(1, userDao.saveUser(user));
	}
	
	@Test
	public void testUpdateUser(){
		when(userDao.updateUser(user)).thenReturn(user);
		assertEquals(user, userDao.updateUser(user));
	}
	
	@Test
	public void testgetUserByEmail(){
		when(userDao.getUserByEmail("abc@def.com")).thenReturn(users);
		assertEquals(users, userDao.getUserByEmail("abc@def.com"));
	}
}
