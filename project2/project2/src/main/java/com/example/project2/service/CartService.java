package com.example.project2.service;

import com.example.project2.model.Cart;
import com.example.project2.model.Category;
import com.example.project2.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CartService {
    ArrayList<Cart> carts = new ArrayList<>();

    public ArrayList<Cart> getCarts(){
        return carts;
    }
    public boolean addCart(Cart cart){
        carts.add(cart);
        return true;
    }
    public Cart findCartByID(String id){
        for (Cart cart:carts) {
            if(id.equals(cart.getId())){
                return cart;
            }
        }
        return null;
    }
}
