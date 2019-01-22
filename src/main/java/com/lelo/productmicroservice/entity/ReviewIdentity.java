package com.lelo.productmicroservice.entity;


import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class ReviewIdentity implements Serializable {

    @NotNull
    private String customerId;
    @NotNull
    private String productId;

    ReviewIdentity(){

    }

    public ReviewIdentity(String customerId,String productId)
    {
        this.customerId=customerId;
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

}
