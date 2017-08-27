package com.jwt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.controller.InvoiceController;
import com.jwt.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger log = Logger.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user.getId();
	}

	@Override
	public User updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return user;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUserByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where email= :email");
		query.setParameter("email", email);
		log.info("Found in DB : " + query.list());
		return query.list();
	}

}
