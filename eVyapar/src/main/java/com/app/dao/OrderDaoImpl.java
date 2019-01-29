package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Order;


@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

	@PersistenceContext
	private EntityManager mgr;
	
	@Override
	public List<Order> listOrders() {
		String jpql="select o from Order o";

		return mgr.createQuery(jpql,Order.class).getResultList();
		
	}

	@Override
	public Order findById(long OrderId) {
		return mgr.find(Order.class,OrderId);
	}

	@Override
	public String addOrder(Order o) {
		mgr.persist(o);
		return "Order added with id "+o.getOrderId();
	}

	@Override
	public String removeOrder(Order o) {
		mgr.remove(o);
		return "Order removed with ID "+o.getOrderId();
	}

	@Override
	public String updateOrder(Order o) {
		mgr.merge(o);
		return "Order updated with id "+o.getOrderId();
	}

}
