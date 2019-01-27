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

import com.app.dao.ProductDao;
import com.app.pojos.Product;
import com.app.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {
	
		@Autowired
		private ProductService service;

		@GetMapping
		public ResponseEntity<List<Product>> getAllProducts() {

			System.out.println("resr srvr : get all custs");
			return new ResponseEntity<List<Product>>(service.listProducts(), OK);
		}

		@GetMapping("/{id}")
		public ResponseEntity<?> getProductById(@PathVariable int id) {
			System.out.println("srvr : get product by id " + id);
			Product  p = service.findById(id);

			if (p != null)
				return new ResponseEntity<Product>(p, OK);
			else
				return new ResponseEntity<String>("Invalid ID", NOT_FOUND);
		}

		@PostMapping
		public ResponseEntity<Product> addProduct(@RequestBody Product p) {
			System.out.println("add Product " + p);
			service.addProduct(p);
			return new ResponseEntity<>(p, HttpStatus.OK);
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<String> deleteProductById(@PathVariable int id) {
			System.out.println("srvr : delete Product by id " + id);
			Product p = service.findById(id);
			if (p != null) {
				System.out.println("deleting Product record");
				service.removeProduct(p);
				return new ResponseEntity<>("Product deleted Successfully with ID " + p.getProductId(), OK);
			}

			return new ResponseEntity<String>("Product deletion Failed : Invalid ID", NOT_FOUND);
		}

		// update Product
		@PutMapping("/{id}")
		public ResponseEntity<?> updateProduct(@PathVariable long id, @RequestBody Product p) {
			System.out.println("update product " + id + " " + p);
			Product p1 = service.findById(id);
			if (p1 != null) {
				// id found
				// REST clnt sends id & updated details BUT w/o id --so setting id
				p.setProductId(id);// o.w insert query will be fired
				System.out.println("before update " + p);
				service.updateProduct(p);
				return new ResponseEntity<>(p, HttpStatus.OK);
			}
			return new ResponseEntity<String>("Product updation Failed : Invalid ID", NOT_FOUND);

		}
		@DeleteMapping("/delete")
		public ResponseEntity<String> deleteAllProducts() {
			System.out.println("Delete All Products...");
			service.deleteAllProducts();
			return new ResponseEntity<>("All Products have been deleted!", HttpStatus.OK);
		}
	}


