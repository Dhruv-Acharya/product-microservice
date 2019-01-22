package com.lelo.productmicroservice.repository;

import com.lelo.productmicroservice.entity.ProductMerchant;
import com.lelo.productmicroservice.entity.ProductMerchantIdentity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMerchantRepository extends CrudRepository<ProductMerchant, ProductMerchantIdentity> {
    //    List<ProductMerchant> findByMerchantId(String merchantId);
//    List<ProductMerchant> findByProductIdAndNotLikeMerchantId(String productId, String merchantId);

//    @Query("select pm from PRODUCT_MERCHANT pm where pm.productId = :productId AND u.merchantId NOT LIKE :merchantId")
//    List<ProductMerchant> findByProductIdNotLikeMerchantId(@Param("productId") String productId,
//                                   @Param("merchantId") String merchantId);
    @Query(value = "SELECT merchant_id FROM PRODUCT_MERCHANT WHERE product_id = :productId", nativeQuery = true)
    List<String> findByProductId(@Param(value = "productId") String productId);
}

