package com.lelo.productmicroservice.controller;


import com.lelo.productmicroservice.dto.CategoryDTO;
import com.lelo.productmicroservice.entity.Category;
import com.lelo.productmicroservice.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @CrossOrigin("*")

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Category> addCategories(@RequestBody CategoryDTO categoriesDTO){
        Category category=new Category();
        BeanUtils.copyProperties(categoriesDTO,category);
        categoryService.add(category);
        return new ResponseEntity<Category>(category,HttpStatus.CREATED);
    }
    @CrossOrigin("*")

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<List<Category>>(categoryService.getAllCategories(),HttpStatus.OK);
    }

}
