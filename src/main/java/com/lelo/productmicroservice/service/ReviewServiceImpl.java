package com.lelo.productmicroservice.service;

import com.lelo.productmicroservice.entity.Review;
import com.lelo.productmicroservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public List<Review> findReview(String merchantId, String productId) {
        List<Review> reviewList = new ArrayList<>();

        Iterable<Review> reviewIterable = reviewRepository.findByMerchantIdAndProductId(merchantId,productId);
        Iterator reviewIterator = reviewIterable.iterator();
        while (reviewIterator.hasNext()) {
            reviewList.add((Review) reviewIterator.next());
        }
        return reviewList;
    }
}
