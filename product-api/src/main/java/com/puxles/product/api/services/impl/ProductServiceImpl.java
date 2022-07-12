package com.puxles.product.api.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.puxles.product.api.errors.ApiException;
import com.puxles.product.api.models.Product;
import com.puxles.product.api.repositories.ProductRepository;
import com.puxles.product.api.services.ProductService;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Integer productId = product.getId();
        if (productRepository.existsById(productId)) {
            return productRepository.save(product);
        }
        throw new ApiException(NOT_FOUND, "El producto no existe");
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.delete(getProductById(productId));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer ProductId) {
        return productRepository.findById(ProductId)
                .orElseThrow(() -> new ApiException(NOT_FOUND, "El producto no existe"));
    }

}
