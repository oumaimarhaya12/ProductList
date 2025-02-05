package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price; // Change from 'double' to 'Double'

    public Product() {}

    public Product(String name, Double price) { // Use Double for price
        this.name = name;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; } // Return type changed to Double
    public void setPrice(Double price) { this.price = price; } // Parameter changed to Double
}