package com.puxles.product.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.puxles.product.api.models.Product;

@Repository
public interface ProductRepository extends MongoRepository <Product, Integer> {
    
}
