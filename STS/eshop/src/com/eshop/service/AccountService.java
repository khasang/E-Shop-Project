package com.eshop.service;

import java.util.List;

import com.eshop.exceptions.UserNotFoundException;
import com.eshop.model.User;

public interface AccountService {
	public void addUser(User user);

	public List<User> getAllUser();

	public User getUserById(Long id) throws UserNotFoundException;

	public void removeUser(Long id);
}
