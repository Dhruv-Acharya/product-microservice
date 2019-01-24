package com.lelo.productmicroservice.controller;


import com.lelo.productmicroservice.dto.ReviewDTO;
import com.lelo.productmicroservice.entity.Review;
import com.lelo.productmicroservice.entity.ReviewIdentity;
import com.lelo.productmicroservice.service.ReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @CrossOrigin("*")
    @RequestMapping(value = "/add/{customerId}/{productId}",method = RequestMethod.POST)
    public ResponseEntity<Review> addReview(@PathVariable("customerId") String customerId, @PathVariable("productId") String productId, @RequestBody ReviewDTO reviewDTO){
        ReviewIdentity reviewIdentity=new ReviewIdentity(customerId,productId);
        Review review=new Review();
        review.setReviewIdentity(reviewIdentity);
        review.setComment(reviewDTO.getComment());
        return new ResponseEntity<Review>(reviewService.save(review), HttpStatus.CREATED);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/getReview/{productId}",method = RequestMethod.GET)
    public ResponseEntity<List<Review>> findAll(@PathVariable("productId") String productId) {
        return new ResponseEntity<>(reviewService.findByProductId(productId), HttpStatus.OK);
    }
}
