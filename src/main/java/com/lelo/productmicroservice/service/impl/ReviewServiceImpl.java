package com.lelo.productmicroservice.service.impl;

import com.lelo.productmicroservice.Utilities.Constans;
import com.lelo.productmicroservice.dto.CustomerDTO;
import com.lelo.productmicroservice.dto.ReviewResponseDTO;
import com.lelo.productmicroservice.entity.Review;
import com.lelo.productmicroservice.repository.ReviewRepository;
import com.lelo.productmicroservice.service.ReviewService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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
    public List<ReviewResponseDTO> findByProductId(String productId) {
        List<Review> review = reviewRepository.findByProductId(productId);
        Iterator iterator = review.iterator();
        List<ReviewResponseDTO> responseDTOList = new ArrayList<>();
        String customerURI;
        while (iterator.hasNext()) {
            ReviewResponseDTO reviewResponseDTO = new ReviewResponseDTO();
            reviewResponseDTO.setComment(((Review) iterator.next()).getComment());
            reviewResponseDTO.setCustomerId(((Review) iterator.next()).getReviewIdentity().getCustomerId());
            reviewResponseDTO.setProductId(((Review) iterator.next()).getReviewIdentity().getProductId());

            customerURI = Constans.CUSTOMER_MICROSERVICE_BASE_URL + "/customer/get/"+reviewResponseDTO.getCustomerId();
            RestTemplate restTemplate = new RestTemplate();
            CustomerDTO productResult = restTemplate.getForObject(customerURI, CustomerDTO.class);
            reviewResponseDTO.setComment(productResult.getName());
            responseDTOList.add(reviewResponseDTO);
        }
        return responseDTOList;
    }
}
