package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@AllArgsConstructor
@Data
public class Comment {
    @NotEmpty(message = "ID cannot be empty")
    @Size(min = 3,message = "ID must be more than 3 Characters long")
    private String id;
    @NotEmpty(message = "User ID cannot be empty")
    @Size(min = 5,message = "User ID must be more than 5 character long")
    private String userID;
    @NotEmpty(message = "Message cannot be empty")
    @Size(min = 6,message = "Message must be more than 6 character long")
    private String message;
    @NotNull(message = "Rate cannot be empty")
    @Range(min = 1,max = 5,message = "Rate must be between 1-5")
    private Integer rate;
}
