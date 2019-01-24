package com.app.service;

import java.util.List;

import com.app.pojos.User;

public interface UserService {
	List<User> listUsers();
	User findById(int userId);
	String addUser(User u);
	String removeUser(User u);
	String updateUser(User u);
	String deleteAllUsers();
	
}