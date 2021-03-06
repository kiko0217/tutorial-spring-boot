package com.domain.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.domain.exceptions.NotFoundDataException;
import com.domain.models.entities.Product;
import com.domain.models.entities.Supplier;
import com.domain.models.repos.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SupplierService supplierService;
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

    public void addSupplier(Supplier supplier, Long productId){
        Product product = findOne(productId);
        if(product == null){
            throw new NotFoundDataException("Product with ID: " + productId + " not found");
        }
        product.getSuppliers().add(supplier);
    }
    public Product findByProductName(String name){
        return productRepo.findProductByName(name);
    }
    public List<Product> findByProductNameLike(String name){
        return productRepo.findProductByNameLike("%"+name+"%");
    }
    public List<Product> findProductByCategory(Long categoryId){
        return productRepo.findProductByCategory(categoryId);   
    }

    public List<Product> findProductBySupplier(Long supplierId){
        Supplier supplier = supplierService.findOne(supplierId);
        if(supplier == null) {
            return new ArrayList<>();
        }
        return productRepo.findProductBySupplier(supplier);
    }
}
