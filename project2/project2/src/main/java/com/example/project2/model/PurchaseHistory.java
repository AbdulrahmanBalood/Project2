package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
@AllArgsConstructor
@Data
public class PurchaseHistory {
    @NotEmpty(message = "ID cannot be empty")
    @Size(message = "ID must be more than 3 Characters long")
    private String id;
    @NotEmpty(message = "User ID cannot be empty")
    @Size(message = "User ID must be more than 3 Characters long")
    private String userID;
    @NotEmpty(message = "Product ID cannot be empty")
    @Size(message = "Product ID must be more than 3 Characters long")
    private String productID;
    @NotNull(message = "Price cannot be empty")
    @Positive(message = "Price must be positive")
    private Integer price;

}
