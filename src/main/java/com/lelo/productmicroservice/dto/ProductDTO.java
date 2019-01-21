package com.lelo.productmicroservice.dto;

public class ProductDTO {
    private String productId;
    private String productName;
    private String usp;
    private String description;
    private String imageUrl;
    private String categoryId;

    public ProductDTO() {
    }

    public ProductDTO(String productId, String productName, String usp, String description, String imageUrl, String categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.usp = usp;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
