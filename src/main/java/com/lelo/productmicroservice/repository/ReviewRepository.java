package com.lelo.productmicroservice.repository;


import com.lelo.productmicroservice.entity.Review;
import com.lelo.productmicroservice.entity.ReviewIdentity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, ReviewIdentity> {
}
