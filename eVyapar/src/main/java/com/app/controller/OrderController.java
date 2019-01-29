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

	import com.app.dao.OrderDao;
	import com.app.pojos.Order;
	import com.app.service.OrderService;

	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/orders")
	public class OrderController {
		
			@Autowired
			private OrderService service;

			@GetMapping
			public ResponseEntity<List<Order>> getAllOrders() {

				System.out.println("resr srvr : get all orders");
				System.out.println(service.listOrders());
				return new ResponseEntity<List<Order>>(service.listOrders(), OK);
			}

			@GetMapping("/{id}")
			public ResponseEntity<?> getOrderById(@PathVariable int id) {
				System.out.println("srvr : get Order by id " + id);
				Order  o = service.findById(id);

				if (o != null)
					return new ResponseEntity<Order>(o, OK);
				else
					return new ResponseEntity<String>("Invalid ID", NOT_FOUND);
			}

			@PostMapping
			public ResponseEntity<Order> addOrder(@RequestBody Order o) {
				System.out.println("add Order " + o);
				service.addOrder(o);
				return new ResponseEntity<>(o, HttpStatus.OK);
			}

			@DeleteMapping("/{id}")
			public ResponseEntity<String> deleteOrderById(@PathVariable int id) {
				System.out.println("srvr : delete Order by id " + id);
				Order o = service.findById(id);
				if (o != null) {
					System.out.println("deleting Order record");
					service.removeOrder(o);
					return new ResponseEntity<>("Order deleted Successfully with ID " + o.getOrderId(), OK);
				}

				return new ResponseEntity<String>("Order deletion Failed : Invalid ID", NOT_FOUND);
			}

			// update Order
			@PutMapping("/{id}")
			public ResponseEntity<?> updateOrder(@PathVariable long id, @RequestBody Order o) {
				System.out.println("update Order " + id + " " + o);
				Order o1 = service.findById(id);
				if (o1 != null) {
					// id found
					// REST clnt sends id & updated details BUT w/o id --so setting id
					o.setOrderId(id);// o.w insert query will be fired
					System.out.println("before update " + o);
					service.updateOrder(o);
					return new ResponseEntity<>(o, HttpStatus.OK);
				}
				return new ResponseEntity<String>("Order updation Failed : Invalid ID", NOT_FOUND);

			}
	}

