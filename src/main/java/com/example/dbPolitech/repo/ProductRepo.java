package com.example.dbPolitech.repo;

import com.example.dbPolitech.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
