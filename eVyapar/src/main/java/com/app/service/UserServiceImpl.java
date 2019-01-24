package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.dao.UserDao;
import com.app.pojos.User;
import com.app.pojos.UserPrinciple;

@Service
@Transactional
public class UserServiceImpl implements UserService,UserDetailsService{
	
	@Autowired
	private UserDao dao;
	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return dao.listUsers();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public String addUser(User u) {
		// TODO Auto-generated method stub
		return dao.addUser(u);
	}

	@Override
	public String removeUser(User u) {
		// TODO Auto-generated method stub
		return dao.removeUser(u);
	}

	@Override
	public String updateUser(User u) {
		// TODO Auto-generated method stub
		return dao.updateUser(u);
	}

	@Override
	public String deleteAllUsers() {
		// TODO Auto-generated method stub
		return dao.deleteAllUsers();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=dao.findByName(username);
		if(user == null)
			throw new UsernameNotFoundException("User by name "+username+" not found!");
		return new UserPrinciple(user);
	}

}
