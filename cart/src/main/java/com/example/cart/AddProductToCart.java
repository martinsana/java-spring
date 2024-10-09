package com.example.cart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductToCart {
    private String productId;
    private int quantity;
}
