package com.lelo.productmicroservice.service;

import com.lelo.productmicroservice.entity.Categories;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoriesService {

    Categories add(Categories categories);
    List<Categories> getAllCategories();
}
