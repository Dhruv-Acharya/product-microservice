package com.lelo.productmicroservice.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = ProductMerchant.TABLE_NAME)
public class ProductMerchant {
    public static final String TABLE_NAME="PRODUCT_MERCHANT";

    @EmbeddedId
    private ProductMerchantIdentity productMerchantIdentity;
    @NotNull
    private double price;
    @NotNull
    private int quantityOffered;
    private int quantitySold;
    private double discount;
    private double rating;
    private double ratingCounter;

    public ProductMerchant() {
    }

    public ProductMerchant(ProductMerchantIdentity productMerchantIdentity, double price, int quantityOffered, int quantitySold, double discount, double rating, double ratingCounter) {
        this.productMerchantIdentity = productMerchantIdentity;
        this.price = price;
        this.quantityOffered = quantityOffered;
        this.quantitySold = quantitySold;
        this.discount = discount;
        this.rating = rating;
        this.ratingCounter = ratingCounter;
    }

    public ProductMerchantIdentity getProductMerchantIdentity() {
        return productMerchantIdentity;
    }

    public void setProductMerchantIdentity(ProductMerchantIdentity productMerchantIdentity) {
        this.productMerchantIdentity = productMerchantIdentity;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRatingCounter() {
        return ratingCounter;
    }

    public void setRatingCounter(double ratingCounter) {
        this.ratingCounter = ratingCounter;
    }
}
