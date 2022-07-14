package com.puxles.product.api.models;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    
    @Transient
    public static final String SEQUENCE_NAME = "product_sequence";

    @Id
    private Integer id;
    private String nombre;
    private BigDecimal precio;
    private int stock;

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

}
