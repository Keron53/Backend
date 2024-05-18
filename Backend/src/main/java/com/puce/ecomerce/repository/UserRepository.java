package com.puce.ecomerce.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puce.ecomerce.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> getByEmail(String email);
}
