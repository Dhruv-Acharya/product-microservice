package com.lelo.productmicroservice.repository;

import com.lelo.productmicroservice.entity.Category;
import com.lelo.productmicroservice.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
    public List<Product> findByCategory(Category category);
}
