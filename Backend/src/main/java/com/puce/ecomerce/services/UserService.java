package com.puce.ecomerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puce.ecomerce.exceptions.ICException;
import com.puce.ecomerce.exceptions.UException;
import com.puce.ecomerce.models.User;
import com.puce.ecomerce.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User registerUser(String firstName, String lastName, String email, String password, String address,
			String phoneNumer) {
		User userNew = new User(firstName, lastName, email, password, address, phoneNumer);
		try {
			return userRepository.save(userNew);
		} catch (Exception e) {
			throw new UException();
		}
	}

	// login
	public User loginUser(String email, String password) {
		User userToLogin= userRepository.getByEmail(email).orElseThrow(ICException:: new);
		if (userToLogin.getPassword().equals(password)) {
			throw new ICException();
		}
		
		return userToLogin;
	}
	// leer usuario
	public User readUser(Integer id) {
		return userRepository.findById(id).get();
	}

	// update
	public User updateUser(User updateUser) {
		User itemUser = userRepository.findById(updateUser.getUserId()).get();
		itemUser.setFirstName(updateUser.getFirstName());
		itemUser.setLastName(updateUser.getLastName());
		itemUser.setEmail(updateUser.getEmail());
		itemUser.setPassword(updateUser.getPassword());
		itemUser.setPhoneNumer(updateUser.getPhoneNumer());
		itemUser.setAddress(updateUser.getAddress());
		return userRepository.save(itemUser);
		}

	// delete
	public String deleteUser(Integer id) {
		User userDelete = userRepository.findById(id).get();
		userRepository.delete(userDelete);
		return "usuario fue eliminado";
	}
}
