package com.puce.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puce.ecomerce.models.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer>{

}
