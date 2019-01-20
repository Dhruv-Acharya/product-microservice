package com.lelo.productmicroservice.controller;


import com.lelo.productmicroservice.dto.CategoryDTO;
import com.lelo.productmicroservice.entity.Category;
import com.lelo.productmicroservice.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Category addCategories(@RequestBody CategoryDTO categoriesDTO){
        Category categories=new Category();
        BeanUtils.copyProperties(categoriesDTO,categories);
        categoryService.add(categories);
        return categories;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

}
