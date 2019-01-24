package com.app.pojos;

import javax.persistence.Column;
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
	
	private Integer UserId;
	private String FullName;
	private String UserName;
	private String password;
	private String UserEmail;
	private String UserPhone;
	
	@OneToMany
	private Address address;

	
	private Role userRole;
	
	//User can have multiple addresses
	
	//User can order multiple items
	//many to one rel

	@ManyToOne
	@JoinColumn(name="order_id")
	private Order orderList; 
	
	
		
	public User() {
		System.out.println("in User ctor");
	}

	

	public User(Integer UserId, String FullName, String UserName, String password, String UserEmail, String UserPhone,
			 Role userRole) {
		super();
		this.UserId = UserId;
		this.FullName = FullName;
		this.UserName = UserName;
		this.password = password;
		this.UserEmail = UserEmail;
		this.UserPhone = UserPhone;
		this.userRole = userRole;
		
	
	}


	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", FullName=" + FullName + ", UserName=" + UserName + ", password=" + password
				+ ", UserEmail=" + UserEmail + ", UserPhone=" + UserPhone + ", address=" + address + ", userRole="
				+ userRole + ", orderList=" + orderList + "]";
	}



	public User(String fullName, String userName, String password, String userEmail, String userPhone, 
			Role userRole) {
		super();
		FullName = fullName;
		UserName = userName;
		this.password = password;
		UserEmail = userEmail;
		UserPhone = userPhone;
		this.userRole = userRole;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer UserId) {
		this.UserId = UserId;
	}
	
	
	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Column(length=30,unique=true)
	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String UserEmail) {
		this.UserEmail = UserEmail;
	}
	@Column(length=10)
	public String getUserPhone() {
		return UserPhone;
	}

	public void setUserPhone(String UserPhone) {
		this.UserPhone = UserPhone;
	}

	@Enumerated(EnumType.STRING)
	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	
	
	/*public Order getOrderList() {
		return orderList;
	}

	public void setOrderList(Order orderList) {
		this.orderList = orderList;
	}*/
	

	

	

	
	
	
	
}
