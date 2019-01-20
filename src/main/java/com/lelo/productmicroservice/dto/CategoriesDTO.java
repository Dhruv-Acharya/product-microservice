package com.lelo.productmicroservice.dto;

public class CategoriesDTO {
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
}
