package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.UserDAO;
import com.eshop.exceptions.UserNotFoundException;
import com.eshop.model.User;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	UserDAO userDAO;

	public AccountServiceImpl() {
		super();
	}

	@Override
	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
	@Transactional
	public List<User> getAllUser() {
		return userDAO.getAllUsers();
	}

	@Override
	@Transactional
	public void removeUser(Long id) {
		userDAO.removeUser(id);
	}

	@Override
	@Transactional
	public User getUserById(Long id) throws UserNotFoundException {
		return userDAO.getUserById(id);
	}
}
