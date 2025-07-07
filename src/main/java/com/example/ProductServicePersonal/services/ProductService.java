package com.example.ProductServicePersonal.services;

import com.example.ProductServicePersonal.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id);
    List<Product> getAllProducts();
    //Product createProduct(Product product);
    Product createProduct(String name, String description, double price, String category, String imageUrl);


}
