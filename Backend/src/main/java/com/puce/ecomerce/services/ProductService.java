package com.puce.ecomerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puce.ecomerce.models.Product;
import com.puce.ecomerce.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	// autowired= integrar o llamar otras clases, modulos
	@Autowired
	ProductRepository productRepository;

	// crear
	public Product createProduct(String name, Double price, Integer amount, String description, String imageUrl) {
		//Crear un objeto product y agregarlo al repositorio
		Product newProduct = new Product(name, price, description, amount, imageUrl);
		return productRepository.save(newProduct);
	}
	
	//leer por id
	public Product readProduct(Integer id) {
		return productRepository.findById(id).get();
	}
	
	//leer todos
	public List<Product> readAllProducts() {
		return productRepository.findAll();
		
	}
	//update
	
	public Product updateProduct(Product product) {
		Product updateItem=productRepository.findById(product.getProductId()).get();
		
		updateItem.setName(product.getName());
		updateItem.setPrice(product.getPrice());
		updateItem.setDescription(product.getDescription());
		updateItem.setImageurl(product.getImageurl());
		
		return productRepository.save(updateItem);
	}
	
	//delete
	
	public String deleteItem(Integer id) {
		Product item= productRepository.findById(id).get();
		productRepository.delete(item);
		return "item ha sido borrado";
	}
}
