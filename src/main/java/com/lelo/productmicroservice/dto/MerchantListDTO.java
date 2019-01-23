package com.lelo.productmicroservice.dto;

public class MerchantListDTO {

    private String merchantId;
    private String name;
    private String emailId;
    private double productRating;
    private double merchantRating;
    private double price;
    private int quantityOffered;
    private int quantitySold;
    private double discount;

    public MerchantListDTO() {
    }

    public MerchantListDTO(String merchantId, String name, String emailId, double productRating, double merchantRating, double price, int quantityOffered, int quantitySold, double discount) {
        this.merchantId = merchantId;
        this.name = name;
        this.emailId = emailId;
        this.productRating = productRating;
        this.merchantRating = merchantRating;
        this.price = price;
        this.quantityOffered = quantityOffered;
        this.quantitySold = quantitySold;
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

    public double getProductRating() {
        return productRating;
    }

    public void setProductRating(double productRating) {
        this.productRating = productRating;
    }

    public double getMerchantRating() {
        return merchantRating;
    }

    public void setMerchantRating(double merchantRating) {
        this.merchantRating = merchantRating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityOffered() {
        return quantityOffered;
    }

    public void setQuantityOffered(int quantityOffered) {
        this.quantityOffered = quantityOffered;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "MerchantListDTO{" +
                "merchantId='" + merchantId + '\'' +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", productRating=" + productRating +
                ", merchantRating=" + merchantRating +
                ", price=" + price +
                ", quantityOffered=" + quantityOffered +
                ", quantitySold=" + quantitySold +
                ", discount=" + discount +
                '}';
    }
}
