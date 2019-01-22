package com.lelo.productmicroservice.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name=Review.TABLE_NAME)

public class Review {

    public static final String TABLE_NAME="REVIEW";
    private static final String ID_COLUMN="ID";

    private String comment;

    @EmbeddedId
    ReviewIdentity reviewIdentity=new ReviewIdentity();

    public Review(){

    }

    public  Review(ReviewIdentity reviewIdentity){
        this.reviewIdentity=reviewIdentity;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
