package com.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.eshop.entity.User;
import com.eshop.repository.UserRepository;
import com.eshop.validation.EmailExistsException;
import com.eshop.validation.LoginExistsException;

public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User registerNewUserAccount(User newUser) throws LoginExistsException,EmailExistsException {
		if (emailExist(newUser.getEmail())) {   
            throw new EmailExistsException("There is an account with that email address:  "+ newUser.getEmail());
        }
		
		if (loginExist(newUser.getLogin())) {   
            throw new EmailExistsException("There is an account with that login:  "+ newUser.getLogin());
        }
		
		return userRepository.save(newUser);
	}
	
	private boolean loginExist(String login) {
	    User user = userRepository.findByLogin(login);
        if (user != null) {
            return true;
        }
        return false;
	}

	 private boolean emailExist(String email) {
	        User user = userRepository.findByEmail(email);
	        if (user != null) {
	            return true;
	        }
	        return false;
	    }
}
