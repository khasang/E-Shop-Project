package com.eshop.service;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.model.User;

@Service("userService")
@Transactional
public class UserService {
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void update(User user) {
	   sessionFactory.getCurrentSession().saveOrUpdate(user);   	    
	}
	
	@SuppressWarnings("unchecked")
	public List<User> selAllUsers(){
		return (List<User>) sessionFactory.getCurrentSession().createQuery("from User").list();
	}
}
