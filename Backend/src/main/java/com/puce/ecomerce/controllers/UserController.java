package com.puce.ecomerce.controllers;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puce.ecomerce.models.User;
import com.puce.ecomerce.services.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User register(@RequestBody LinkedHashMap<String,String> body) {
		String firstName= body.get("firstName");
		String lastName= body.get("lastName");
		String email= body.get("email");
		String password= body.get("password");
		String address= body.get("address");
		String phoneNumber= body.get("phoneNumber");
		
		return userService.registerUser(firstName, lastName, email, password, address, phoneNumber);
	}
	
	@GetMapping("/user")
	public User readUser(@RequestParam(name="id") Integer id) {
		return userService.readUser(id);
	}
	
	@PutMapping("/Update")
	public User update(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestBody LinkedHashMap<String, Integer> body) {
		return userService.deleteUser(body.get("id"));
	}
	
	@PostMapping("/login")
	public User login(@RequestBody LinkedHashMap<String, String> body) {
		String email = body.get("email");
		String password = body.get("password");
		
		return userService.loginUser(email, password);
	}
}
