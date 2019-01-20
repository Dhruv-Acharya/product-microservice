package com.lelo.productmicroservice.service.impl;

import com.lelo.productmicroservice.entity.Review;
import com.lelo.productmicroservice.repository.ReviewRepository;
import com.lelo.productmicroservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    @Transactional(readOnly = false)
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
