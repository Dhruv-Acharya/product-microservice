package com.lelo.productmicroservice.dto;

public class MerchantDTO {
    private String merchantId;
    private String name;

    public MerchantDTO() {
    }

    public MerchantDTO(String merchantId, String name) {
        this.merchantId = merchantId;
        this.name = name;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
