package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eshop.dao.UserDAO;
import com.eshop.exceptions.UserNotFoundException;
import com.eshop.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		user.addRole();
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public void removeUser(Long id) {
		User user = sessionFactory.getCurrentSession().load(User.class, id);
		if (user != null) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	@Override
	public User getUserById(Long id) throws UserNotFoundException {
		User user = sessionFactory.getCurrentSession().load(User.class, id);
		if (user == null) {
			throw new UserNotFoundException("User not found");
		}
		return user;
	}
}
