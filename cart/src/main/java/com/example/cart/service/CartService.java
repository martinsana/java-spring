package com.example.cart.service;


import com.example.cart.Cart;
import com.example.cart.Product;
import com.example.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CartService {


    private CartRepository cartRepository;
    private ProductService productService;
    private UserService userService;

    public CartService(CartRepository cartRepository, ProductService productService, UserService userService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.userService = userService;
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart updateCart(String id, Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(String id) {
        cartRepository.deleteById(id);
    }

    public Cart getCart(String id) { return cartRepository.findById(id).orElseThrow(() ->new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
    ));}

    public Cart addProductToCart(String productID, String cartID, int quantity) {
         var productDetails = productService.getProductById(productID);
         productDetails.setProductQuantity(quantity);
         productDetails.setProductSubTotal(quantity * productDetails.getProductPrice());
         var cartDetails =  this.getCart(cartID);
         cartDetails.setTotal(cartDetails.getTotal() + productDetails.getProductSubTotal());
         cartDetails.getProducts().add(productDetails);
         return cartRepository.save(cartDetails);
    };

    public Cart addUserToCart(String userID, String cartID, String username) {
        var userDetails = userService.getUserById(userID);
        userDetails.setUsername(username);
        var cartDetails =  this.getCart(cartID);
        cartDetails.setUser(userDetails);
        return cartRepository.save(cartDetails);
    }
}
