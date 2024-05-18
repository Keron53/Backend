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
import com.puce.ecomerce.models.Receipt;
import com.puce.ecomerce.services.ReceiptService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("receipts")
@CrossOrigin("*")
@AllArgsConstructor
public class ReceiptController {
	
	@Autowired
	private ReceiptService rServ;

	class ReceiptRegisterObject {
		public Integer userId;
		public List<Product> items;
		public Integer amountOfItems;
	}

	@PostMapping("/create")
	public Receipt create(@RequestBody ReceiptRegisterObject rro) {
		Integer userId = rro.userId;
		List<Product> products = rro.items;
		return rServ.createReceipt(userId, products);
	}

	@GetMapping("/read")
	public Receipt read(@RequestBody LinkedHashMap<String, Integer> body) {
		return rServ.readReceipt(body.get("id"));
	}

	@PutMapping("/update")
	public Receipt update(@RequestBody Receipt r) {
		return rServ.updateReceipt(r);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestBody LinkedHashMap<String, Integer> body) {
		return rServ.deleteReceipt(body.get("id"));
	}
}
