package com.lelo.productmicroservice.service;

import com.lelo.productmicroservice.entity.Category;
import com.lelo.productmicroservice.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> getByCategory(Category category);
//    String[] getCarousel();
Product findOne(String productId);

}
