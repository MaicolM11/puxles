package com.puxles.product.api.services;

import java.util.List;

import com.puxles.product.api.models.Product;

public interface ProductService {

    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Integer productId);
    
    List<Product> getAllProducts();
    Product getProductById(Integer ProductId);

}
