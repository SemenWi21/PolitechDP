package com.example.dbPolitech.repo;

import com.example.dbPolitech.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
