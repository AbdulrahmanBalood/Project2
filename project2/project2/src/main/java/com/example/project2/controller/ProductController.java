package com.example.project2.controller;

import com.example.project2.model.Comment;
import com.example.project2.model.Product;
import com.example.project2.model.ResponseAPI;
import com.example.project2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Period;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<ArrayList<Product>> getProducts(){
        return ResponseEntity.status(200).body((productService.getProducts()));
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseAPI> addProduct(@RequestBody @Valid Product product, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ResponseAPI(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!productService.addProducts(product)){
            return ResponseEntity.status(500).body(new ResponseAPI("Server error adding a product",500));
        }
        return ResponseEntity.status(200).body(new ResponseAPI("Product added successfully",200));
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseAPI> updateProduct(@RequestBody @Valid Product product,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ResponseAPI(errors.getFieldError().getDefaultMessage(),400));
        }
        if(productService.updateProduct(product)){
            return ResponseEntity.status(200).body(new ResponseAPI("Product updated",200));
        }
        return ResponseEntity.status(400).body(new ResponseAPI("Product not found",400));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseAPI> deleteProduct(@PathVariable String id){
        if(productService.deleteProduct(id)){
            return ResponseEntity.status(200).body(new ResponseAPI("Product deleted",200));
        }
        return ResponseEntity.status(400).body(new ResponseAPI("Product not found",400));
    }
    @GetMapping("/productcomments/{productID}")
    public ResponseEntity<ArrayList<Comment>> productComments(@PathVariable String  productID){
        return ResponseEntity.status(200).body(productService.productComments(productID));
    }
    @GetMapping("/fivestarproducts")
    public ResponseEntity <ArrayList<Product>> fiveStarProducts(){
        return ResponseEntity.status(200).body(productService.fiveStarProducts());
    }


}
