package com.example.cart;

import com.example.cart.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cart {
    private String id;
    private int total;
    private List<Product> products;
    private User user;
}
