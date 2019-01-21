package com.lelo.productmicroservice.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class ProductMerchantIdentity implements Serializable {
    @NotNull
    private String productId;
    @NotNull
    private String merchantId;

    public ProductMerchantIdentity() {
    }

    public ProductMerchantIdentity(String productId, String merchantId) {
        this.productId = productId;
        this.merchantId = merchantId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
}
