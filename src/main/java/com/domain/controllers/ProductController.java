package com.domain.controllers;

import com.domain.models.entities.Product;
import com.domain.models.entities.ProductRequestModel;
import com.domain.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product create(@RequestBody ProductRequestModel productRequest){
        Product product = new Product(productRequest.getId(),productRequest.getName(),productRequest.getDescription(),productRequest.getPrice());
        return productService.save(product);
    }

    @GetMapping
    public Iterable<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id){
        return productService.findOne(id);
    }

    @PutMapping
    public Product update(@RequestBody ProductRequestModel productUpdateRequest){
        Product product = new Product(productUpdateRequest.getId(),productUpdateRequest.getName(),productUpdateRequest.getDescription(),productUpdateRequest.getPrice());
        return productService.save(product);
    }
    
    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        productService.removeOne(id);
    }
}