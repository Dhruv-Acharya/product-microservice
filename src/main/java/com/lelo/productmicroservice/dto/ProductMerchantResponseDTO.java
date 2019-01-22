package com.lelo.productmicroservice.dto;

public class ProductMerchantResponseDTO {
    private String productId;
    private String merchantId;
    private String name;
    private String usp;
    private String description;
    private String imageUrl;
    private double price;
    private int quantityOffered;
    private double discount;
    private double rating;
    private String categoryName;

    public ProductMerchantResponseDTO() {
    }

    public ProductMerchantResponseDTO(String productId, String merchantId, String name, String usp, String description, String imageUrl, double price, int quantityOffered, double discount, double rating, String categoryName) {
        this.productId = productId;
        this.merchantId = merchantId;
        this.name = name;
        this.usp = usp;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.quantityOffered = quantityOffered;
        this.discount = discount;
        this.rating = rating;
        this.categoryName = categoryName;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsp() {
        return usp;
    }

    public void setUsp(String usp) {
        this.usp = usp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
