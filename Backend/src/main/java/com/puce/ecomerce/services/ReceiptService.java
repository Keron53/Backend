package com.puce.ecomerce.services;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puce.ecomerce.models.Product;
import com.puce.ecomerce.models.Receipt;
import com.puce.ecomerce.models.User;
import com.puce.ecomerce.repository.ProductRepository;
import com.puce.ecomerce.repository.ReceiptRepository;
import com.puce.ecomerce.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class ReceiptService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ReceiptRepository receiptRepository;
	@Autowired
	UserRepository userRepository;

	// transaccional
	public Receipt createReceipt(String email, List<Product> product, Double total) {
		User userReceipt = userRepository.getByEmail(email).get();
		Receipt newReceipt = new Receipt(userReceipt, product, total, getdateTime(), product.size());
		return receiptRepository.save(newReceipt);

	}

	// crear los productos del recibo
	public Receipt createReceipt(Integer id, List<Product> product) {
		User userReceipt = userRepository.findById(id).get();
		List<Product> itemsReceipt = new ArrayList<>();
		Integer amountOfItems = 0;
		Double total = 0.0;

		for (Product item : product) {
			Product addItem = productRepository.findById(item.getProductId()).get();
			addItem.setAmount(item.getAmount());
			total += item.getPrice() * item.getAmount();
			amountOfItems += item.getAmount();
			itemsReceipt.add(addItem);
		}
		DecimalFormat df = new DecimalFormat("0,00");
		total = Double.parseDouble(df.format(total));
		Receipt newReceipt = new Receipt(userReceipt, itemsReceipt, total, getdateTime(), amountOfItems);
		return receiptRepository.save(newReceipt);
	}

	// leerlo
	public Receipt readReceipt(Integer id) {
		return receiptRepository.findById(id).get();
	}

	// update
	public Receipt updateReceipt(Receipt updateItem) {
		Receipt updateReceipt = receiptRepository.findById(updateItem.getReceiptNumber()).get();
		updateReceipt.setAmountOfItems(updateItem.getAmountOfItems());
		updateReceipt.setDateTime(updateItem.getDateTime());
		updateReceipt.setProduct(updateItem.getProduct());
		updateReceipt.setTotal(updateItem.getTotal());
		updateReceipt.setUser(updateItem.getUser());
		return receiptRepository.save(updateReceipt);
	}
	// delete

	public String deleteReceipt(Integer id) {
		receiptRepository.delete(receiptRepository.findById(id).get());
		return "receipt fue borrado";
	}

	public String getdateTime() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm");
		return LocalDateTime.now().format(format);
	}
}
