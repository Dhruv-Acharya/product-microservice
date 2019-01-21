package com.lelo.productmicroservice.controller;

//
//import com.lelo.productmicroservice.dto.ReviewDTO;
//import com.lelo.productmicroservice.entity.Review;
//import com.lelo.productmicroservice.entity.ReviewIdentity;
//import com.lelo.productmicroservice.service.ReviewService;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/review")
//public class ReviewController {
//
//    @Autowired
//    ReviewService reviewService;
//
//    @RequestMapping(value = "/add/{customer_id}/{product_id}/{merchant_id}",method = RequestMethod.POST)
//    public void addReview(@PathVariable("customer_id") String customerId, @PathVariable("product_id") String productId,
//                          @PathVariable("merchant_id")String merchantId, @RequestParam String comment){
//
//        ReviewDTO reviewDTO=new ReviewDTO();
//        reviewDTO.setCustomerId(customerId);
//        reviewDTO.setProductId(productId);
//        reviewDTO.setMerchantId(merchantId);
//        reviewDTO.setComment(comment);
//        ReviewIdentity reviewIdentity=new ReviewIdentity(customerId,productId,merchantId);
//        Review review=new Review(reviewIdentity);
//        BeanUtils.copyProperties(reviewDTO,review);
//       reviewService.addReview(review);
//    }
//
//    @RequestMapping(value = "/getReview/{product_id}/{merchant_id}",method = RequestMethod.GET)
//    public List<Review> findAll(@PathVariable("product_id") String productId,
//                                @PathVariable("merchant_id") String merchantId) {
//        return reviewService.findReview(productId,merchantId);
//    }
//}
