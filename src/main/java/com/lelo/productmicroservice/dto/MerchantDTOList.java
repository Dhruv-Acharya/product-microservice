package com.lelo.productmicroservice.dto;

import java.util.List;

public class MerchantDTOList {
    List<MerchantDTO> merchantDTOList;

    public MerchantDTOList() {
    }

    public MerchantDTOList(List<MerchantDTO> merchantDTOList) {
        this.merchantDTOList = merchantDTOList;
    }

    public List<MerchantDTO> getMerchantDTOList() {
        return merchantDTOList;
    }

    public void setMerchantDTOList(List<MerchantDTO> merchantDTOList) {
        this.merchantDTOList = merchantDTOList;
    }
}
