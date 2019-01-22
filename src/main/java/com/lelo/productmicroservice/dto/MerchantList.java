package com.lelo.productmicroservice.dto;

import java.util.List;

public class MerchantList {
    List<String> merchantList;

    public MerchantList() {
    }

    public MerchantList(List<String> merchantList) {
        this.merchantList = merchantList;
    }

    public List<String> getMerchantList() {
        return merchantList;
    }

    public void setMerchantList(List<String> merchantList) {
        this.merchantList = merchantList;
    }
}
