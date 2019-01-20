package com.lelo.productmicroservice.controller;


import com.lelo.productmicroservice.dto.ReviewDTO;
import com.lelo.productmicroservice.entity.Review;
import com.lelo.productmicroservice.service.ReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addReview(@RequestBody ReviewDTO reviewDTO){
        Review review=new Review();
        BeanUtils.copyProperties(reviewDTO,review);
        reviewService.addReview(review);
    }

    //@RequestMapping(value = "/getReview",method = RequestMethod.GET)
    //public List<String>
}
