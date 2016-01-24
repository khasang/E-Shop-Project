package com.eshop.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 8309681890708900738L;
	@Id
	@GeneratedValue
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private long id;
	@Enumerated(EnumType.STRING)
	private ListRole listRole = ListRole.ROLE_USER;
	@ManyToMany(mappedBy = "userRoles")
	private Set<User> user = new HashSet<User>();

	public UserRole() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ListRole getListRole() {
		return listRole;
	}

	public void setListRole(ListRole listRole) {
		this.listRole = listRole;
	}

	@Override
	public String toString() {
		return listRole.name();
	}

	public UserRole(long id) {
		this.id = id;
	}
}
