package com.lelo.productmicroservice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = Product.TABLE_NAME)
public class Product {
    public static final String TABLE_NAME="PRODUCT";
    private static final String ID_COLUMN="ID";
    @Id
    @GeneratedValue(generator ="uuid")                 // hibernate
    @GenericGenerator( name="uuid", strategy = "uuid2")
    private String productId;
    @NotNull
    private String name;
    @NotNull
    private String usp;
    private String description;
    private String imageUrl;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
    private double rating;
    private double ratingCounter;
    private double lowestPrice;
    private double highestPrice;

    public Product() {
    }

    public Product(String productId, String name, String usp, String description, String imageUrl, Category category, double rating, double ratingCounter, double lowestPrice, double highestPrice) {
        this.productId = productId;
        this.name = name;
        this.usp = usp;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.rating = rating;
        this.ratingCounter = ratingCounter;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(double highestPrice) {
        this.highestPrice = highestPrice;
    }
}
