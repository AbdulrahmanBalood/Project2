package com.example.project2.controller;

import com.example.project2.model.Cart;
import com.example.project2.service.CartService;
import com.example.project2.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    @GetMapping
    public ResponseEntity<ArrayList<Cart>> getCart(){
        return ResponseEntity.status(200).body((cartService.getCarts()));
    }
}
