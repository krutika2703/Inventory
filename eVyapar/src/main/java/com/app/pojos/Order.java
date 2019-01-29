package com.app.pojos;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	@Column(columnDefinition="double(7,1)")
	private double amount;
	
	private int quantity;
	
	@ManyToOne @JsonBackReference// mandatory
	@JoinColumn(name = "adder_id") // optional
	private Address address;
	
	//one order can have multiple products
	
	@ManyToMany(targetEntity = Product.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "product_order", 
				joinColumns = { @JoinColumn(name = "orderId") }, 
				inverseJoinColumns = { @JoinColumn(name = "productId") })
	@ElementCollection(targetClass=Product.class)
	private List<Product> product;

	
	public Order() {
		System.out.println("in order ctor");
	}
	
	
	
	public List<Product> getProduct() {
		return product;
	}



	public void setProduct(List<Product> product) {
		this.product = product;
	}



	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	
	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}



	public Address getAddr() {
		return address;
	}



	public void setAddr(Address addr) {
		this.address = addr;
	}



	public Long getOrderId() {
		return orderId;
	}



	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", amount=" + amount + ", quantity="
				+ quantity +"]";
	}
	
}