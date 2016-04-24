package com.eshop.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.eshop.entity.User;

@Component
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> inClass) {
		return User.class.isAssignableFrom(inClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password",
				"Field password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required.confirmPassword",
				"Please confirm password");
		User user = (User) target;
		if (!(user.getPassword().equals(user.getConfirmPassword()))) {
			errors.rejectValue("password", "notmatch.password", "Password and Confirm password is not match!");
		}
	}
}
