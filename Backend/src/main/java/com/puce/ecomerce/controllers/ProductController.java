package com.puce.ecomerce.controllers;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.puce.ecomerce.models.Product;
import com.puce.ecomerce.services.ProductService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("Products")
@CrossOrigin("*")
@AllArgsConstructor
public class ProductController {
	
	@Autowired
	private ProductService pServ;
	
	@PostMapping("/Create")
	public Product create(@RequestBody LinkedHashMap<String, Object> body) {
		String name = (String) body.get("name");
		Double price = (Double) body.get("price");
		Integer amount =1;
		String description = (String) body.get("description");
		String imageUrl = (String) body.get("imageUrl");
		
		return pServ.createProduct(name, price, amount, description, imageUrl);
	}
	
	@GetMapping("/read")
	public Product read(@RequestBody LinkedHashMap<String, Integer> body) {
		return pServ.readProduct(body.get("id"));
	}
	
	@GetMapping("/read/all")
	public List<Product> readAll() {
		return pServ.readAllProducts();
	}
	
	@PutMapping("/update")
	public Product update(@RequestBody Product product) {
		return pServ.updateProduct(product);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestBody LinkedHashMap<String, Integer> body) {
		return pServ.deleteItem(body.get("id"));
	}
	
	
	
}


