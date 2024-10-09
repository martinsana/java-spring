package com.example.product.controller;

import com.example.product.Product;
import com.example.product.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    public ProductsService productsService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        return productsService.addProduct(product);

    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        return productsService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String id) {
        productsService.deleteProduct(id);

    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productsService.getProductById(id);
    }

    @PatchMapping("/{id}/quantity")
    public void addProductQuantity(@PathVariable String id, @RequestParam int quantity) {
        productsService.addProductQuantity(id, quantity);
    }

    @DeleteMapping("/{id}/quantity")
    public void removeProductQuantity(@PathVariable String id, @RequestParam int quantity) {
        productsService.removeProductQuantity(id, quantity);
    }
}

