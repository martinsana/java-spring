package com.example.cart.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class User {
    @Id
    private ObjectId id;
    private String username;
    private String email;
}
