package com.puce.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puce.ecomerce.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
