package com.domain.services;

import java.util.List;

import javax.transaction.Transactional;

import com.domain.models.entities.Product;
import com.domain.models.repos.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Product findOne(Long id){
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
            return product.get(); // no issue
        }
        return null;
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public void removeOne(Long id){
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
        }
    }

    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }
}
