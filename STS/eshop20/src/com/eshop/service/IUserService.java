package com.eshop.service;

import com.eshop.entity.User;
import com.eshop.validation.EmailExistsException;
import com.eshop.validation.LoginExistsException;

public interface IUserService {
	 User registerNewUserAccount(User newUser) throws LoginExistsException,EmailExistsException;
}
