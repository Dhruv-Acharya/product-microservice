package com.lelo.productmicroservice.repository;

import com.lelo.productmicroservice.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {
}
