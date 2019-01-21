package com.lelo.productmicroservice.service.impl;

import com.lelo.productmicroservice.entity.ProductMerchant;
import com.lelo.productmicroservice.entity.ProductMerchantIdentity;
import com.lelo.productmicroservice.repository.ProductMerchantRepository;
import com.lelo.productmicroservice.service.ProductMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMerchantServiceImpl implements ProductMerchantService {

    @Autowired
    private ProductMerchantRepository productMerchantRepository;


    @Override
    public ProductMerchant getProductMerchant(ProductMerchantIdentity productMerchantIdentity) {
        return productMerchantRepository.findOne(productMerchantIdentity);
    }

    @Override
    public ProductMerchant addProductMerchant(ProductMerchant productMerchant) {
        return productMerchantRepository.save(productMerchant);
    }

//    @Override
//    public List<ProductMerchant> findByMerchantId(String merchantId) {
//        return productMerchantRepository.findByMerchantId(merchantId);
//    }

//    @Override
//    public List<ProductMerchant> findByDifferentMerchantId(String productId, String merchantId) {
//        return productMerchantRepository.findByProductIdNotLikeMerchantId(productId, merchantId);
//    }

    @Override
    public boolean updateQuantity(ProductMerchant productMerchant, int quantitySold) {
        int newQuantity = productMerchant.getQuantityOffered() - quantitySold;
        productMerchant.setQuantitySold(productMerchant.getQuantitySold() + quantitySold);
        productMerchant.setQuantityOffered(newQuantity);
        ProductMerchant updatedProductMerchant = productMerchantRepository.save(productMerchant);
        if (updatedProductMerchant != null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addRating(ProductMerchant productMerchant, double rating) {
        double newRating = productMerchant.getRating() + rating;
        double newRatingCounter = productMerchant.getRatingCounter() + 1;
        productMerchant.setRating(newRating / newRatingCounter);
        productMerchant.setRatingCounter(newRatingCounter);
        ProductMerchant updatedProductMerchant = productMerchantRepository.save(productMerchant);
        if (updatedProductMerchant != null){
            return true;
        } else {
            return false;
        }
    }
}
