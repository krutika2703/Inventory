package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ProductDao;
import com.app.dao.UserDao;
import com.app.pojos.Product;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	@Override
	public List<Product> listProducts() {
		
		return dao.listProducts();
	}

	@Override
	public Product findById(long productId) {
		
		return dao.findById(productId);
	}

	@Override
	public String addProduct(Product p) {
		
		return dao.addProduct(p);
	}

	@Override
	public String removeProduct(Product p) {
		return dao.removeProduct(p);
	}

	@Override
	public String updateProduct(Product p) {
		return dao.updateProduct(p);
	}

	@Override
	public String deleteAllProducts() {
		return dao.deleteAllProducts();
	}

}
