package com.lelo.productmicroservice.service;

import com.lelo.productmicroservice.dto.ReviewResponseDTO;
import com.lelo.productmicroservice.entity.Review;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;

import java.util.List;

public interface ReviewService {
    Review save(Review review);
    Review remove(String reviewId);
    List<ReviewResponseDTO> findByProductId(String productId);
}
