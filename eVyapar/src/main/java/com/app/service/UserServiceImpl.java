package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.pojos.Address;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
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
	public User login(String uname, String pass) {
		return dao.login(uname, pass);
	}

	@Override
	public void insertAddress(List<Address> addr) {
		dao.insertAddress(addr);
		
	}

}
