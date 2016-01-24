package com.eshop.dao;

import java.util.List;

import com.eshop.exceptions.UserNotFoundException;
import com.eshop.model.User;

public interface UserDAO {
	public void addUser(User user);

	public User getUserById(Long id) throws UserNotFoundException;

	public List<User> getAllUsers();

	public void removeUser(Long id);
}
