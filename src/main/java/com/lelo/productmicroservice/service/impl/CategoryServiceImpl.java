package com.lelo.productmicroservice.service.impl;

import com.lelo.productmicroservice.entity.Category;
import com.lelo.productmicroservice.repository.CategoryRepository;
import com.lelo.productmicroservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryRepository categoryRepository;
    @Override
    @Transactional(readOnly = false)
    public Category add(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();

        Iterable<Category> categoryIterable = categoryRepository.findAll();
        Iterator categoryIterator = categoryIterable.iterator();
        while (categoryIterator.hasNext()) {
            categoryList.add((Category) categoryIterator.next());
        }
        return categoryList;
    }

    @Override
    public Category findOne(String categoryId) {
        return categoryRepository.findOne(categoryId);
    }
}
