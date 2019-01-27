package com.app.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Warehouse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="warehouse_id")
	private Long warehouseId;
	private String address;
	private String productLoc;
	
	@ElementCollection(targetClass=Product.class)
	@OneToMany(mappedBy="warehouse")	//ones side
	private List<Product> product;  //one wh---many prod

	public Warehouse() {
		System.out.println("in whouse ctor");
	}


	public Long getWarehouseId() {
		return warehouseId;
	}


	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProductLoc() {
		return productLoc;
	}

	public void setProductLoc(String productLoc) {
		this.productLoc = productLoc;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
}
