package com.app.dao;

import java.util.List;

import com.app.pojos.Product;


public interface ProductDao {

	List<Product> listProducts();
	Product findById(long productId);
	String addProduct(Product p);
	String removeProduct(Product p);
	String updateProduct(Product p);
	String deleteAllProducts();
}
