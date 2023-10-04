package com.example.dbPolitech.repo;


import com.example.dbPolitech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
