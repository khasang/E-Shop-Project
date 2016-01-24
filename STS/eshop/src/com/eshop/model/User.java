package com.eshop.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails {
	private static final long serialVersionUID = -930110079518261599L;
	@Id
	@GeneratedValue
	@Column(name = "user_id", insertable = false, updatable = false, nullable = false)
	private long id;
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	@Column(name = "enabled")
	private int enabled = 1;
	@Column(name = "password")
	private String password;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Order> userOrderList = new ArrayList<>();
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id") , inverseJoinColumns = @JoinColumn(name = "role_id") )
	private Set<UserRole> userRoles = new HashSet<>();

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, int enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;

	}

	public User(String username, String password, int enabled, UserRole userRole) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		userRoles.add(userRole);
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public List<Order> getUserOrderList() {
		return userOrderList;
	}

	public void setUserOrderList(List<Order> userOrderList) {
		this.userOrderList = userOrderList;
	}

	public void addRole() {
		UserRole userRole = new UserRole();
		userRole.setListRole(ListRole.ROLE_USER);
		userRoles.add(userRole);
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> result = new ArrayList<>();
		for (UserRole userRole : userRoles) {
			result.add(new SimpleGrantedAuthority(userRole.getListRole().name()));
		}
		return result;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
