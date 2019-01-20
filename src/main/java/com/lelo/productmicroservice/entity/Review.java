package com.lelo.productmicroservice.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name=Review.TABLE_NAME)

public class Review {

    public static final String TABLE_NAME="REVIEW";
    private static final String ID_COLUMN="ID";


    @Id
    @GeneratedValue(generator ="uuid")                 // hibernate
    @GenericGenerator( name="uuid", strategy = "uuid2")  //hibernate
    @Column(name =Review.ID_COLUMN)
    private String reviewId;
    private String comment;

    @EmbeddedId
    ReviewIdentity reviewUtility=new ReviewIdentity();

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
