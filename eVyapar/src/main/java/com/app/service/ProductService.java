package com.app.service;


import java.util.List;

import com.app.pojos.Product;


public interface ProductService {

	List<Product> listProducts();
	Product findById(long productId);
	String addProduct(Product p);
	String removeProduct(Product p);
	String updateProduct(Product p);
	String deleteAllProducts();
}
