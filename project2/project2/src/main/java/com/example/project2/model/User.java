package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.validation.constraints.*;

@AllArgsConstructor
@Data
public class User {
    @NotEmpty(message = "ID cannot be empty")
    @Size(min = 3,message = "ID must be more than 3 Characters long")
    private String id;
    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 3,message = "Username must be more than 3 Characters long")
    private String username;
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 6,message = "Password must be more than 6 Characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$",message = "Password must contain both characters and digits")
    private String password;
    @NotEmpty(message = "Email cannot e empty")
    @Email(message = "Must be a valid email")
    private String email;
    @NotEmpty(message = "Role cannot be empty")
    @Pattern(regexp = "(?i)(Admin|Customer)",message = "User role must be Admin or customer")
    private String role;
    @NotNull(message = "Balance cannot be empty")
    @Positive(message = "Balance must be positive")
    private Integer balance;

}
