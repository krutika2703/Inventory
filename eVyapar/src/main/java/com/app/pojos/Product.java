package com.app.pojos;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

///many to many relation

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private int productStock;
	private double productMRP;
	private double discount;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] image;

	@ManyToOne // mandatory
	@JoinColumn(name = "warehouse_id") // optional
	private Warehouse warehouse;

	public Product() {
		super();

	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public double getProductMRP() {
		return productMRP;
	}

	public void setProductMRP(double productMRP) {
		this.productMRP = productMRP;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

}
