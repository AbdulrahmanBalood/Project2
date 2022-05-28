package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@AllArgsConstructor
@Data
public class Merchant {
    @NotEmpty(message = "ID cannot be empty")
    @Size(min = 3,message = "ID must be more than 3 character long")
    private String id;
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3,message = "Name must be more than 3 character long")
    private String name;
}
