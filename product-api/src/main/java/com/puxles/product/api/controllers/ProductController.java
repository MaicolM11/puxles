package com.puxles.product.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.puxles.product.api.models.Product;
import com.puxles.product.api.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable("productId") Integer productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Product updateProduct(@Valid @RequestBody Product product, @PathVariable("productId") Integer productId) {
        product.setId(productId);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCampaign(@PathVariable("productId") Integer productId) {
        productService.deleteProduct(productId);
    }
    
}
