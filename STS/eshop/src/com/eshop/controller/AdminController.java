package com.eshop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.exceptions.UserNotFoundException;
import com.eshop.model.ListRole;
import com.eshop.model.User;
import com.eshop.model.UserRole;
import com.eshop.service.AccountService;

@Controller
public class AdminController {
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "install")
	public String installAdmin() {
		User admin = new User("admin", "admin", 1);
		User user = new User("user", "user", 1, new UserRole());

		UserRole userRole = new UserRole();
		userRole.setListRole(ListRole.ROLE_ADMIN);
		admin.getUserRoles().add(userRole);
		try {
			accountService.addUser(admin);
			accountService.addUser(user);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/admin/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result) {
		try {
			accountService.addUser(user);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
		}
		return "redirect:/admin/users";
	}

	@RequestMapping("/admin/delete/{userId}")
	public String deleteUser(@PathVariable("userId") Long userId) {
		accountService.removeUser(userId);
		return "redirect:/admin/users";
	}

	@RequestMapping("/admin/users")
	public String listContacts(Map<String, Object> map) {
		map.put("user", new User());
		map.put("userList", accountService.getAllUser());
		return "usermanager";
	}

	@RequestMapping("/admin/backup")
	public String backup() {
		return "backup";
	}

	@RequestMapping("/admin/shrink")
	public String shrink() {
		return "shrink";
	}

	@RequestMapping("/admin/userpage/{userID}")
	public String userPage(@PathVariable("userID") Long userId, User user) {
		try {
			user = (User) accountService.getUserById(userId);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return "userpage";
	}
}
