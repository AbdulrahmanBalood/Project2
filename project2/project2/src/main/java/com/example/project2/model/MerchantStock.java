package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@AllArgsConstructor
@Data
public class MerchantStock {
    @NotEmpty(message = "ID cannot be empty")
    @Size(min = 3,message = "ID must be more than 3 character long")
    private String id;
    @NotEmpty(message = "Product ID cannot be empty")
    @Size(min = 3,message = "Product ID must be more than 3 character long")
    private String productID;
    @NotEmpty(message = "Merchant ID cannot be empty")
    @Size(min = 3,message = "MerchantID must be more than 3 character long")
    private String merchantID;
    @NotNull(message = "Stock cannot be empty")
    @Min(value = 10,message = "Stock must be 10 or more")
    private Integer stock;
}
