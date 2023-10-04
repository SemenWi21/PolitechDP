package com.example.dbPolitech.repo;

import com.example.dbPolitech.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepo extends JpaRepository<Vendor, Long> {
}
