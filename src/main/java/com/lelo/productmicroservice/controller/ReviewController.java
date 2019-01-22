package com.lelo.productmicroservice.controller;


import com.lelo.productmicroservice.dto.ReviewDTO;
import com.lelo.productmicroservice.entity.Review;
import com.lelo.productmicroservice.entity.ReviewIdentity;
import com.lelo.productmicroservice.service.ReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @RequestMapping(value = "/add/{customer_id}/{product_id}/{merchant_id}",method = RequestMethod.POST)
    public void addReview(@PathVariable("customer_id") String customerId, @PathVariable("product_id") String productId, @RequestBody String comment){
        ReviewIdentity reviewIdentity=new ReviewIdentity(customerId,productId);
        Review review=new Review(reviewIdentity);
        review.setComment(comment);
       reviewService.save(review);
    }

    @RequestMapping(value = "/getReview/{product_id}/{merchant_id}",method = RequestMethod.GET)
    public List<Review> findAll(@PathVariable("product_id") String productId,
                                @PathVariable("merchant_id") String merchantId) {
        return reviewService.findByProductIdAndMerchantId(productId,merchantId);
    }
}
