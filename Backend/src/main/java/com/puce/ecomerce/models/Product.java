package com.puce.ecomerce.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer productId;

	@Column(name = "product_name")
	private String name;

	private Double price;

	private String description;

	private Integer amount;

	private String imageurl;

	public Product() {
	}

	public Product(Integer productId, String name, Double price, String description, Integer amount, String imageurl) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.amount = amount;
		this.imageurl = imageurl;
	}

	public Product(String name, Double price, String description, Integer amount, String imageurl) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.amount = amount;
		this.imageurl = imageurl;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

}
