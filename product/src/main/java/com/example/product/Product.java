package com.example.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String id;
    private String productName;
    private int productPrice;
    private int productQuantity;
    private Boolean soldOut;
}


