package com.lelo.productmicroservice.service;

import com.lelo.productmicroservice.entity.Review;

import java.util.List;

public interface ReviewService {

    void addReview(Review review);
    List<Review> findReview(String merchantId,String productId);
}
