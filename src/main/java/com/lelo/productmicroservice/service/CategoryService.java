package com.lelo.productmicroservice.service;

import com.lelo.productmicroservice.entity.Category;

import java.util.List;

public interface CategoryService {

    Category add(Category categories);
    List<Category> getAllCategories();
}
