package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
	
	@PersistenceContext
	private EntityManager mgr;

	
	@Override
	public List<Product> listProducts() {
		String jpql="select p from Product p";

		return mgr.createQuery(jpql,Product.class).getResultList();
	}

	@Override
	public Product findById(long productId) {
		// TODO Auto-generated method stub
		return mgr.find(Product.class,productId);
	
	}


	@Override
	public String addProduct(Product p) {

		mgr.persist(p);
			return "Product added with id "+p.getProductId();

	}

	@Override
	public String removeProduct(Product p) {

		mgr.remove(p);
		return "Product removed with ID "+p.getProductId();

	}

	@Override
	public String updateProduct(Product p) {

		mgr.merge(p);
		return "Product updated with id "+p.getProductId();
}

	@Override
	public String deleteAllProducts() {

		String jpql="select p from Product p";
		mgr.createQuery(jpql,Product.class).getResultList().forEach(p->mgr.remove(p));
		return "Deleted all product";
}

	
}
