package com.app.service;

import java.util.List;

import com.app.pojos.Order;

public interface OrderService {
	List<Order> listOrders();
	Order findById(long OrderId);
	String addOrder(Order o);
	String removeOrder(Order o);
	String updateOrder(Order o);
}
