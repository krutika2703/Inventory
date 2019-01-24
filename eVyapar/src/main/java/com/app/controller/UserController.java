package com.app.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.*;
import com.app.pojos.User;
import com.app.service.UserService;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {

		System.out.println("resr srvr : get all custs");
		return new ResponseEntity<List<User>>(service.listUsers(), OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id) {
		System.out.println("srvr : get cust by id " + id);
		User u = service.findById(id);

		if (u != null)
			return new ResponseEntity<User>(u, OK);
		else
			return new ResponseEntity<String>("Invalid ID", NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User u) {
		System.out.println("add user " + u);
		service.addUser(u);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable int id) {
		System.out.println("srvr : delete user by id " + id);
		User u = service.findById(id);
		if (u != null) {
			System.out.println("deleting User record");
			service.removeUser(u);
			return new ResponseEntity<>("User deleted Successfully with ID " + u.getUserId(), OK);
		}

		return new ResponseEntity<String>("User deletion Failed : Invalid ID", NOT_FOUND);
	}

	// update User
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User u) {
		System.out.println("update user " + id + " " + u);
		User u1 = service.findById(id);
		if (u1 != null) {
			// id found
			// REST clnt sends id & updated details BUT w/o id --so setting id
			u.setUserId(id);// o.w insert query will be fired
			System.out.println("before update " + u);
			service.updateUser(u);
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		return new ResponseEntity<String>("User updation Failed : Invalid ID", NOT_FOUND);

	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAllUsers() {
		System.out.println("Delete All Users...");
		service.deleteAllUsers();
		return new ResponseEntity<>("All Users have been deleted!", HttpStatus.OK);
	}
}
