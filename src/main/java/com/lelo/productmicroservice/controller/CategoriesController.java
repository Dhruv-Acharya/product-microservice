package com.lelo.productmicroservice.controller;


import com.lelo.productmicroservice.dto.CategoriesDTO;
import com.lelo.productmicroservice.entity.Categories;
import com.lelo.productmicroservice.service.CategoriesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Categories addCategories(@RequestBody CategoriesDTO categoriesDTO){
        Categories categories=new Categories();
        BeanUtils.copyProperties(categoriesDTO,categories);
        categoriesService.add(categories);
        return categories;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Categories> getAllCategories(){
        return categoriesService.getAllCategories();
    }

}
