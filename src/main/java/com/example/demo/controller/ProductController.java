package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.example.demo.exception.ResourceNotFoundException;
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> existingProductOptional = productService.getProductById(id);

        if (!existingProductOptional.isPresent()) {
            throw new ResourceNotFoundException("Product not found with ID: " + id);
        }

        Product existingProduct = existingProductOptional.get();

        // Update only the fields that are not null in the request
        if (product.getName() != null && !product.getName().isEmpty()) {
            existingProduct.setName(product.getName());
        }
        if (product.getPrice() != null) {  // Check if price is not null
            existingProduct.setPrice(product.getPrice());
        }

        // Save the updated product
        return productService.updateProduct(id, existingProduct);
    }



    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }
}
