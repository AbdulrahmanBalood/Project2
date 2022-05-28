package com.example.project2.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
@Data
public class Cart {
    @NotEmpty(message = "ID cannot be empty")
    @Size(min = 3,message = "ID must be more than 3 Characters long")
    private String id;
    @NotEmpty(message = "User ID cannot be empty")
    @Size(min = 3,message = "User ID must be more than 3 Characters long")
    private String userid;

    public Cart(String id, String userid, ArrayList<Product> cartProducts) {
        this.id = id;
        this.userid = userid;
        cartProducts = new ArrayList<>();
    }

    private ArrayList<Product> cartProducts;
}
