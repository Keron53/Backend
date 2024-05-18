package com.puce.ecomerce.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name= "user_id")
	private Integer userId;
	@Column(name= "first_name")
	private String firstName;
	@Column(name= "last_name")
	private String lastName;
	
	//restriccion a la columna email
	@Column(unique = true) //usa el valor por defecto
	private String email;
	@NotEmpty
	@Column
	private String password;
	@Column
	private String address;
	@Column
	private String phoneNumer;
	
	//relacion con otra tabla receipt
	//Una relacion de uno a muchos desde el receipt hacia el usuario
	@OneToMany(mappedBy =  "user", cascade= CascadeType.ALL)
	private List<Receipt> userReceipts; //se convierte en un listado
	
	public User(Integer userId, String firstName, String lastName, String email, String password, String address,
			String phoneNumer) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNumer = phoneNumer;
	}

	public User(String firstName, String lastName, String email, String password, String address, String phoneNumer) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNumer = phoneNumer;
	}
	
	public User() {
		
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumer() {
		return phoneNumer;
	}

	public void setPhoneNumer(String phoneNumer) {
		this.phoneNumer = phoneNumer;
	}
	
	
	

}
