package com.lelo.productmicroservice.repository;

import com.lelo.productmicroservice.entity.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends CrudRepository<Categories, String> {
}
