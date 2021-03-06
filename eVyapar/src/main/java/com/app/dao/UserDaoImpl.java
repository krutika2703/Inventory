package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Address;
import com.app.pojos.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager mgr;

	@Override
	public List<User> listUsers() {
		String jpql="select c from User c";
		return mgr.createQuery(jpql, User.class).getResultList();
	}

	@Override
	public User findById(int userId) {
		
		return mgr.find(User.class, userId);
	}

	@Override
	public String addUser(User u) {
		mgr.persist(u);
		System.out.println(u);
		return "User added with ID "+u.getUserId();
	}

	@Override
	public String removeUser(User c) {
		mgr.remove(c);
		return "User removed with ID "+c.getUserId();
	}

	@Override
	public String updateUser(User c) {
		mgr.merge(c);
		return "User updated with ID "+c.getUserId();
	}

	@Override
	public String deleteAllUsers() {
		String jpql="select c from User c";
		 mgr.createQuery(jpql, User.class).getResultList().forEach(c->mgr.remove(c));
		 return "Deleted all Users ";
	}

	@Override
	public User login(String uname, String pass) {
		
		String jpql="select u from User u where u.userName=:uname and u.password=:password";
		return mgr.createQuery(jpql, User.class).setParameter("uname",uname).setParameter("password", pass).getSingleResult();
	}

	@Override
	public void insertAddress(List<Address> addr,User u) {
		for(Address addre : addr){
			addre.setUser(u);
		mgr.persist(addre);
		}
		
	}

}
