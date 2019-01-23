package com.lelo.productmicroservice.dto;

public class MerchantListResponseDTO {

    private String merchantId;
    private String name;
    private String emailId;
    private double rating;
    private double price;
    private int qunatity;
    private double discount;

    public MerchantListResponseDTO() {
    }

    public MerchantListResponseDTO(String merchantId, String name, String emailId, double rating, double price, int qunatity, double discount) {
        this.merchantId = merchantId;
        this.name = name;
        this.emailId = emailId;
        this.rating = rating;
        this.price = price;
        this.qunatity = qunatity;
        this.discount = discount;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQunatity() {
        return qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
