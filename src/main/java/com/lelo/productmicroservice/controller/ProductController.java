package com.lelo.productmicroservice.controller;

import com.lelo.productmicroservice.dto.MerchantListResponseDTO;
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
@RequestMapping(value = "/product")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductMerchantService productMerchantService;

    @CrossOrigin("*")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO) {
        Product product = new Product();

        Category category = categoryService.findOne(productDTO.getCategoryId());
        product.setImageUrl(productDTO.getImageUrl());
        product.setCategory(category);
        product.setDescription(productDTO.getDescription());
        product.setName(productDTO.getName());
        product.setUsp(productDTO.getUsp());

        Product createdProduct = productService.save(product);

        return new ResponseEntity<>(createdProduct.getProductId(), HttpStatus.CREATED);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/getByCategory/{categoryId}", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getByCategory(@PathVariable String categoryId) {
        Category category = categoryService.findOne(categoryId);

        List<Product> products = productService.getByCategory(category);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/get/{productId}", method = RequestMethod.GET)
    public ResponseEntity<Product> findByProductId(@PathVariable String productId) {
        return new ResponseEntity<>(productService.findOne(productId), HttpStatus.OK);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/get/{productId}/{merchantId}", method = RequestMethod.GET)
    public ResponseEntity<ProductMerchantDTO> findByProductIdAndMerchantId(@PathVariable String productId, @PathVariable String merchantId) {
        ProductMerchantIdentity productMerchantIdentity = new ProductMerchantIdentity(productId, merchantId);
        ProductMerchant productMerchant = productMerchantService.getProductMerchant(productMerchantIdentity);
//        Product product = productService.findOne(productMerchant.getProductMerchantIdentity().getProductId());
//        String categoryName = product.getCategory().getName();
        ProductMerchantDTO productMerchantDTO= new ProductMerchantDTO();
        BeanUtils.copyProperties(productMerchant, productMerchantDTO);
        productMerchantDTO.setProductId(productId);
        productMerchantDTO.setMerchantId(merchantId);
//        BeanUtils.copyProperties(productMerchant, product);
//        productMerchantResponseDTO.setCategoryName(categoryName);
        return new ResponseEntity<ProductMerchantDTO>(productMerchantDTO, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/add/{productId}/{merchantId}", method = RequestMethod.POST)
    public ResponseEntity<ProductMerchant> addProductMerchant(@RequestBody ProductMerchantDTO productMerchantDTO) {
        ProductMerchantIdentity productMerchantIdentity = new ProductMerchantIdentity(productMerchantDTO.getProductId(),productMerchantDTO.getMerchantId());
        ProductMerchant productMerchant = new ProductMerchant();
        BeanUtils.copyProperties(productMerchantDTO, productMerchant);
        productMerchant.setProductMerchantIdentity(productMerchantIdentity);
        return new ResponseEntity<>(productMerchantService.addProductMerchant(productMerchant), HttpStatus.CREATED);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/updateQuantity/{productId}/{merchantId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateQuantity(@PathVariable String productId, @PathVariable String merchantId, @RequestBody ProductMerchantDTO productMerchantDTO) {
        ProductMerchantIdentity productMerchantIdentity = new ProductMerchantIdentity(productId, merchantId);
        ProductMerchant productMerchant = productMerchantService.getProductMerchant(productMerchantIdentity);
        boolean result = productMerchantService.updateQuantity(productMerchant, productMerchantDTO.getQuantitySold());
        if(result) {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failure", HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/rating/add/{productId}", method = RequestMethod.PUT)
    public ResponseEntity<String> addRating(@PathVariable String productId, @RequestBody ProductMerchantDTO productMerchantDTO) {
//        ProductMerchant productMerchant = productMerchantService.getProductMerchant(productMerchantIdentity);
        Product product = productService.findOne(productId);
        boolean result = productMerchantService.addRating(product, productMerchantDTO.getRating());
        if(result) {
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Failure", HttpStatus.OK);
        }
    }

//    @CrossOrigin("*")
//    @RequestMapping(value = "/getCarousel", method = RequestMethod.GET)
//    public ResponseEntity<String[]> getCarousel(){
//        return new ResponseEntity<String[]>(productService.getCarousel(), HttpStatus.OK);
//    }

    @CrossOrigin("*")
    @RequestMapping(value = "/getMerchants/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<MerchantListResponseDTO>> getMerchants(@PathVariable String productId) {
        return new ResponseEntity<>(productMerchantService.getMerchantFromProduct(productId), HttpStatus.OK);
    }
}
