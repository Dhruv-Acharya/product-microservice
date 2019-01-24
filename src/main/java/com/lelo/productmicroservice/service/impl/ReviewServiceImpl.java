package com.lelo.productmicroservice.service.impl;

import com.lelo.productmicroservice.entity.Review;
import com.lelo.productmicroservice.repository.ReviewRepository;
import com.lelo.productmicroservice.service.ReviewService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }
    @Override
    public Review remove(String reviewId) {
        return null;
    }

    @Override
    public List<Review> findByProductId(String productId) {
        return reviewRepository.findByProductId(productId);
    }
}
