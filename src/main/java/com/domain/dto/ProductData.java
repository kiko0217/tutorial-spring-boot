package com.domain.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class ProductData {
    private Long id;
    
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Description is required")
    private String description;
    private double price;
    private CategoryData category;
    private List<SupplierData> suppliers;
    
    public List<SupplierData> getSuppliers() {
        return suppliers;
    }
    public void setSuppliers(List<SupplierData> suppliers) {
        this.suppliers = suppliers;
    }
    
    public CategoryData getCategory() {
        return category;
    }
    public void setCategory(CategoryData category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
}
