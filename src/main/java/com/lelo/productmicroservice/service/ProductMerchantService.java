package com.lelo.productmicroservice.service;

import com.lelo.productmicroservice.dto.MerchantDTO;
import com.lelo.productmicroservice.dto.MerchantListResponseDTO;
import com.lelo.productmicroservice.entity.Product;
import com.lelo.productmicroservice.entity.ProductMerchant;
import com.lelo.productmicroservice.entity.ProductMerchantIdentity;

import java.util.List;

public interface ProductMerchantService {
    public ProductMerchant getProductMerchant(ProductMerchantIdentity productMerchantIdentity);
    public ProductMerchant addProductMerchant(ProductMerchant productMerchant);
    List<MerchantListResponseDTO> getMerchantFromProduct(String productId);
//    public List<ProductMerchant> findByMerchantId(String merchantId);
//    public List<ProductMerchant> findByDifferentMerchantId(String productId, String merchantId);
    public boolean updateQuantity(ProductMerchant productMerchant, int quantitySold);
    public boolean addRating(Product product, double rating);
}
