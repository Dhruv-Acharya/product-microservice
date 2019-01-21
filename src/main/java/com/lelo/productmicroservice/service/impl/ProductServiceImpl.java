package com.lelo.productmicroservice.service.impl;

import com.lelo.productmicroservice.entity.Category;
import com.lelo.productmicroservice.entity.Product;
import com.lelo.productmicroservice.repository.CategoryRepository;
import com.lelo.productmicroservice.repository.ProductRepository;
import com.lelo.productmicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getByCategory(Category category) {
        List<Product> productList = new ArrayList<>();

        Iterable<Product> productIterable = productRepository.findByCategory(category);
        Iterator employeeIterator = productIterable.iterator();
        while (employeeIterator.hasNext()) {
            productList.add((Product) employeeIterator.next());
        }
        return productList;
    }

    @Override
    public Product findOne(String productId) {
        return productRepository.findOne(productId);
    }
}
