package com.lelo.productmicroservice.service;

import com.lelo.productmicroservice.entity.Category;
import com.lelo.productmicroservice.entity.Product;

import java.util.List;

public interface ProductService {
    public Product save(Product product);
    public List<Product> getByCategory(Category category);
    public Product findOne(String productId);
}
