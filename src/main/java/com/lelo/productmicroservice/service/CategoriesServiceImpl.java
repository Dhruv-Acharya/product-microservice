package com.lelo.productmicroservice.service;

import com.lelo.productmicroservice.entity.Categories;
import com.lelo.productmicroservice.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
public class CategoriesServiceImpl implements CategoriesService {


    @Autowired
    CategoriesRepository categoriesRepository;
    @Override
    @Transactional(readOnly = false)
    public Categories add(Categories categories) {
        return categoriesRepository.save(categories);
    }

    @Override
    public List<Categories> getAllCategories() {
        List<Categories> categoryList = new ArrayList<>();

        Iterable<Categories> employeeIterable = categoriesRepository.findAll();
        Iterator categoryIterator = employeeIterable.iterator();
        while (categoryIterator.hasNext()) {
            categoryList.add((Categories) categoryIterator.next());
        }
        return categoryList;
    }
}
