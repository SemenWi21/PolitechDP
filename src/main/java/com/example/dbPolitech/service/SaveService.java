package com.example.dbPolitech.service;

import com.example.dbPolitech.model.Category;
import com.example.dbPolitech.model.Product;
import com.example.dbPolitech.model.Vendor;
import com.example.dbPolitech.repo.CategoryRepo;
import com.example.dbPolitech.repo.ProductRepo;
import com.example.dbPolitech.repo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private VendorRepo vendorRepo;

    public void saveProduct(Object first, Object second,Object tree){
        Product product = new Product();
        product.setName((String) first);
        product.setCategory(Long.getLong(second.toString()));
        product.setType((String) tree);

        productRepo.save(product);
    }
    public void saveCategory(Object first, Object second,Object tree){
        Category category = new Category();
        category.setName((String) first);
        category.setEstimate((String) tree);
        category.setFresh((String) second);

        categoryRepo.save(category);
    }
    public void saveVendor(Object first, Object second,Object tree){
        Vendor vendor = new Vendor();
        vendor.setName((String) first);
        vendor.setCountry((String) second);
        vendor.setTypeTransport((String) tree);

        vendorRepo.save(vendor);
    }
}
