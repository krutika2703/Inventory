package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.OrderDao;
import com.app.pojos.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao dao;
	@Override
	public List<Order> listOrders() {
		// TODO Auto-generated method stub
		return dao.listOrders();
	}

	@Override
	public Order findById(long OrderId) {
		// TODO Auto-generated method stub
		return dao.findById(OrderId);
	}

	@Override
	public String addOrder(Order o) {
		// TODO Auto-generated method stub
		return dao.addOrder(o);
	}

	@Override
	public String removeOrder(Order o) {
		// TODO Auto-generated method stub
		return dao.removeOrder(o);
	}

	@Override
	public String updateOrder(Order o) {
		// TODO Auto-generated method stub
		return dao.updateOrder(o);
	}

}
