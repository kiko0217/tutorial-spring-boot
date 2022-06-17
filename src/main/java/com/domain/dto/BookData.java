package com.domain.dto;

import javax.validation.constraints.Size;

public class BookData {
    private Long id;
    @Size(max = 255, message = "title max 255 characters")
    private String title;
    @Size(max = 255, message = "description max 255 characters")
    private String description;
    
    private double price;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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
