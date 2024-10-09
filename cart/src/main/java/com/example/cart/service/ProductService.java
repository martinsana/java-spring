package com.example.cart.service;

import com.example.cart.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    public Product getProductById(String productId) {
        RestTemplate restTemplate = new RestTemplate();
        String productResourceUrl
                = "http://localhost:8080/products/";
        ResponseEntity<Product> response
                = restTemplate.getForEntity(productResourceUrl + productId, Product.class);
        return response.getBody();
    }
}
