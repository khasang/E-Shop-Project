package com.eshop.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.model.User;
import com.eshop.model.UserRoles;

public interface UserRepository extends CrudRepository<User, String> {
	@Modifying
	@Transactional
	@Query("update User set role = :role where login = :login")
	int setRole(@Param("login") String login, @Param("role") UserRoles role);
}
