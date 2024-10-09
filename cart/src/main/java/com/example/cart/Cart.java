package com.example.cart;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cart {
    private String id;
    private int total;
    private List<Product> products;
}
