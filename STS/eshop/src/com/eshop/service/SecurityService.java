package com.eshop.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.model.User;

@Named
@Transactional
public class SecurityService implements UserDetailsService {
	@Inject
	SessionFactory sessionFactory;

	public SecurityService() {
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username");
		query.setParameter("username", username);
		User result = (User) query.uniqueResult();
		if (result == null)
			throw new UsernameNotFoundException("user not found!");
		return result;
	}
}
