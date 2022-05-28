package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;
@AllArgsConstructor
@Data
public class Product {
    @NotEmpty(message = "ID cannot be empty")
    @Size(min = 3,message = "ID must be more than 3 character long")
    private String id;
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3,message = "ID must be more than 3 character long")
    private String name;
    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be positive")
    private Integer price;
    @NotEmpty(message = "Category ID cannot be empty")
    @Size(min = 3,message = "Category ID must be more than 3 character long")
    private String  categoryID;
    private ArrayList<Comment> comment;
}
