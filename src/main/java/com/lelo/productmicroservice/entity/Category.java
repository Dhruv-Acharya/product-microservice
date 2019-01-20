package com.lelo.productmicroservice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name=Category.TABLE_NAME)
public class Category {

    public static final String TABLE_NAME="CATEGORIES";
    private static final String ID_COLUMN="ID";
    @Id
    @GeneratedValue(generator ="uuid")                 // hibernate
    @GenericGenerator( name="uuid", strategy = "uuid2")  //hibernate
    @Column(name =Category.ID_COLUMN)
    private String categoriesId;
    private String name;

    public String getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(String categoriesId) {
        this.categoriesId = categoriesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoriesId='" + categoriesId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}