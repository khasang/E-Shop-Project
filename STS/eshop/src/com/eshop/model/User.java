package com.eshop.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Id
	@Column(name = "LOGIN", unique = true)
	private String login;

	@Column(name = "PASSWORD")
	private String password;

	@Transient
	private String confirmPassword;

	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE")
	private UserRoles role = UserRoles.ROLE_USER;

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public UserRoles getRole() {
		return role;
	}

	public void setRole(UserRoles role) {
		this.role = role;
	}

	public List<UserRoles> getRolesValues() {
		return Arrays.asList(UserRoles.values());
	}

	public String toString() {
		return "name=" + name + ",email=" + email + ",login=" + login + ",password=" + password;
	}
}
