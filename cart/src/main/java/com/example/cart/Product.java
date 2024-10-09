package com.example.cart;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String id;
    @Schema(example = "Product name")
    private String productName;
    private int productPrice;
    private int productQuantity;
    private int productSubTotal;
}

