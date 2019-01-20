package com.lelo.productmicroservice.entity;


import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ReviewIdentity {

    @NotNull
    private String customerId;
    @NotNull
    private String productId;
    @NotNull
    private String merchantId;

    ReviewIdentity(){

    }

    ReviewIdentity(String customerId,String productId,String merchantId)
    {
        this.customerId=customerId;
        this.merchantId=merchantId;
        this.productId=productId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
