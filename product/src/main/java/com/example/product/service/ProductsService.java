package com.example.product.service;

import com.example.product.Product;
import com.example.product.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    public ProductsRepository productsRepository;
    public Product addProduct(Product product) {
        return productsRepository.save(product);
    }

    public Product updateProduct(String id, Product product) {
        return productsRepository.save(product);
    }

    public void deleteProduct(String id) {
        productsRepository.deleteById(id);
    }

    public Product getProductById(String id) {
        return productsRepository.findById(id).orElseThrow(() ->new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        ));
    }

    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }

    public void addProductQuantity(String id, Integer quantity) {
        var product = getProductById(id);
        var newProductQuantity = product.getProductQuantity()+quantity;
        product.setProductQuantity(newProductQuantity);
        productsRepository.save(product);

    }

    public void removeProductQuantity(String id, Integer quantity) {
        var product = getProductById(id);
        if (product.getProductQuantity() < quantity) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "not enough products");
        }
        var newProductQuantity = product.getProductQuantity()-quantity;
        product.setProductQuantity(newProductQuantity);
        productsRepository.save(product);
    }

}
