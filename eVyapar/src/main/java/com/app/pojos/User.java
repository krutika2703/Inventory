package com.app.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.enums.Role;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	private String fullName;
	private String userName;
	private String password;
	private String userEmail;
	private String userPhone;
	
	@OneToMany(mappedBy="user")
	@ElementCollection
	private List<Address> address;

	
	private Role userRole;
	
	//User can have multiple addresses
	
	//User can order multiple items
	//many to one rel

	@ManyToOne
	@JoinColumn(name="order_id")
	private Order orderList; 
	
	
		
	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public String getUserPhone() {
		return userPhone;
	}



	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}





	public List<Address> getAddress() {
		return address;
	}



	public void setAddress(List<Address> address) {
		this.address = address;
	}



	public Role getUserRole() {
		return userRole;
	}



	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}



	public Order getOrderList() {
		return orderList;
	}



	public void setOrderList(Order orderList) {
		this.orderList = orderList;
	}



	public User() {
		System.out.println("in User ctor");
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", userName=" + userName + ", password=" + password
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", address=" + address + ", userRole="
				+ userRole + ", orderList=" + orderList + "]";
	}

	

	


	
	/*public Order getOrderList() {
		return orderList;
	}

	public void setOrderList(Order orderList) {
		this.orderList = orderList;
	}*/
	

	

	

	
	
	
	
}
