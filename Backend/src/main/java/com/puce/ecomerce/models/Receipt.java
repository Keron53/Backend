package com.puce.ecomerce.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "receipt")
public class Receipt {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "receipt_number")
	private Integer receiptNumber;

	// persistencia de datos
	// hacia la tabla user

	// relacion de muchos a uno para user
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by")
	private User user;

	// relacion de muchos a muchos de receipt a products
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "items_on_receipt", // crear la tabla con relacion hacia las otras dos
			joinColumns = { @JoinColumn(name = "receiptNumber") }, inverseJoinColumns = {
					@JoinColumn(name = "TtemId") })
	private List<Product> product;
	
	private Double total;
	
	@Column(name="create_data_time")
	private String dateTime;
	
	private Integer amountOfItems;

	public Receipt(Integer receiptNumber, User user, List<Product> product, Double total, String dateTime,
			Integer amountOfItems) {
		this.receiptNumber = receiptNumber;
		this.user = user;
		this.product = product;
		this.total = total;
		this.dateTime = dateTime;
		this.amountOfItems = amountOfItems;
	}
	
	public Receipt(User user, List<Product> product, Double total, String dateTime,
			Integer amountOfItems) {
		this.user = user;
		this.product = product;
		this.total = total;
		this.dateTime = dateTime;
		this.amountOfItems = amountOfItems;
	}
	
	public Receipt() {
		
	}

	public Integer getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(Integer receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getAmountOfItems() {
		return amountOfItems;
	}

	public void setAmountOfItems(Integer amountOfItems) {
		this.amountOfItems = amountOfItems;
	}
	
	
	
	
	

}
