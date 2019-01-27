package com.app.pojos;

import java.util.List;

import javax.persistence.*;


@Entity
public class Address {

	//private String fullName;
	
	//private String building;
	@Column(length=30)
	private String street;
	private String city;
	private int pincode;
	private String state;
	private String country;
	
	@ManyToOne // mandatory
	@JoinColumn(name = "user_id") // optional
	private User user;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer addr_id;
	/*
	@OneToMany(mappedBy="address")	//ones side
	@ElementCollection(targetClass=Order.class)
	private List<Order> order; 

*/
	@OneToMany(mappedBy="address")
	@ElementCollection
	private List<Order> order; 

	
	public Address() {
		System.out.println("in addr ctor");
	}
	
	
	public Address(String street, String city, int pincode, String state, String country) {
		super();
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
		
	}

	


	public int getAddr_id() {
		return addr_id;
	}


	public void setAddr_id(int addr_id) {
		this.addr_id = addr_id;
	}


	
	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public int getPincode() {
		return pincode;
	}



	public void setPincode(int pincode) {
		this.pincode = pincode;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCountry() {
		return country;
	}


	
	public void setCountry(String country) {
		this.country = country;
	}



	
	public List<Order> getOrder() {
		return order;
	}


	public void setOrder(List<Order> order) {
		this.order = order;
	}


	public User getUser() {
		return user;
	}


	
	public void setUser(User user) {
		this.user = user;
	}


	public void setAddr_id(Integer addr_id) {
		this.addr_id = addr_id;
	}


	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", pincode=" + pincode + ", state=" + state
				+ ", country=" + country + ", user=" + user + ", addr_id=" + addr_id + ", order=" + order + "]";
	}
	
	
	
	
}
