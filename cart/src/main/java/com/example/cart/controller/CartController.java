package com.example.cart.controller;

import com.example.cart.AddProductToCart;
import com.example.cart.Cart;
import com.example.cart.domain.AddUserToCart;
import com.example.cart.service.CartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    @Tag(name = "Create cart")
    @ResponseStatus(HttpStatus.CREATED)
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cart updateCart(@PathVariable String id, @RequestBody Cart cart) {
        return cartService.updateCart(id, cart);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCart(@PathVariable String id) {
        cartService.deleteCart(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cart getCart(@PathVariable String id) {
        return cartService.getCart(id);
    }

    @PostMapping("/{cartId}/product")
    public Cart addProductToCart(@PathVariable String cartId, @RequestBody AddProductToCart addProductToCart ) {
        return cartService.addProductToCart(addProductToCart.getProductId(), cartId, addProductToCart.getQuantity());
    }

    @PostMapping("/{cartId}/user")
    public Cart addUserToCart(@PathVariable String cartId, @RequestBody AddUserToCart addUserToCart ) {
        return cartService.addUserToCart(addUserToCart.getUserId(), cartId, addUserToCart.getUsername());
    }

}
