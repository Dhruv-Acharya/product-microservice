package com.lelo.productmicroservice.controller;

import com.lelo.productmicroservice.dto.ProductDTO;
import com.lelo.productmicroservice.dto.ProductMerchantDTO;
import com.lelo.productmicroservice.entity.Category;
import com.lelo.productmicroservice.entity.Product;
import com.lelo.productmicroservice.entity.ProductMerchant;
import com.lelo.productmicroservice.entity.ProductMerchantIdentity;
import com.lelo.productmicroservice.service.CategoryService;
import com.lelo.productmicroservice.service.ProductMerchantService;
import com.lelo.productmicroservice.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductMerchantService productMerchantService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO) {
        Product product = new Product();

        Category category = new Category();
        category = categoryService.findOne(productDTO.getCategoryId());
        product.setImageUrl(productDTO.getImageUrl());
        product.setCategory(category);
        product.setDescription(productDTO.getDescription());
        product.setProductName(productDTO.getProductName());
        product.setUsp(productDTO.getUsp());

        Product createdProduct = productService.save(product);

        return new ResponseEntity<String>(createdProduct.getProductId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getByCategory/{categoryId}", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getByCategory(@PathVariable String categoryId) {
        Category category = categoryService.findOne(categoryId);

        List<Product> products = productService.getByCategory(category);

        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{productId}/{merchantId}", method = RequestMethod.GET)
    public ResponseEntity<ProductMerchant> findByProductIdAndMerchantId(@PathVariable String productId, @PathVariable String merchantId) {
        ProductMerchantIdentity productMerchantIdentity = new ProductMerchantIdentity(productId, merchantId);
        return new ResponseEntity<ProductMerchant>(productMerchantService.getProductMerchant(productMerchantIdentity),HttpStatus.OK);
    }

    @RequestMapping(value = "/add/{productId}/{merchantId}", method = RequestMethod.POST)
    public ResponseEntity<ProductMerchant> addProductMerchant(@RequestBody ProductMerchantDTO productMerchantDTO) {
        ProductMerchantIdentity productMerchantIdentity = new ProductMerchantIdentity(productMerchantDTO.getProductId(),productMerchantDTO.getMerchantId());
        ProductMerchant productMerchant = new ProductMerchant();
        BeanUtils.copyProperties(productMerchantDTO, productMerchant);
        productMerchant.setProductMerchantIdentity(productMerchantIdentity);
        return new ResponseEntity<ProductMerchant>(productMerchantService.addProductMerchant(productMerchant), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateQuantity/{productId}/{merchantId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateQuantity(@PathVariable String productId, @PathVariable String merchantId, @RequestBody ProductMerchantDTO productMerchantDTO) {
        ProductMerchantIdentity productMerchantIdentity = new ProductMerchantIdentity(productId, merchantId);
        ProductMerchant productMerchant = productMerchantService.getProductMerchant(productMerchantIdentity);
        boolean result = productMerchantService.updateQuantity(productMerchant, productMerchantDTO.getQuantitySold());
        if(result) {
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Failure", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/rating/add/{productId}/{merchantId}", method = RequestMethod.PUT)
    public ResponseEntity<String> addRating(@PathVariable String productId, @PathVariable String merchantId, @RequestBody ProductMerchantDTO productMerchantDTO) {
        ProductMerchantIdentity productMerchantIdentity = new ProductMerchantIdentity(productId, merchantId);
        ProductMerchant productMerchant = productMerchantService.getProductMerchant(productMerchantIdentity);
        boolean result = productMerchantService.addRating(productMerchant, productMerchantDTO.getRating());
        if(result) {
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Failure", HttpStatus.OK);
        }
    }
}
