package com.baig.ecommerce.productcatalogue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ProductCatalogue {
    @Id
    private Integer id;
    private String category;
    private String subcategory;
    private List<Product> products;

    public ProductCatalogue(Integer id, String category, String subcategory, List<Product> products) {
        this.id = id;
        this.category = category;
        this.subcategory = subcategory;
        this.products = products;
    }

    public ProductCatalogue(){

    }

    public Integer getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
