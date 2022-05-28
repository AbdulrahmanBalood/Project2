package com.example.project2.controller;

import com.example.project2.model.Category;
import com.example.project2.model.ResponseAPI;
import com.example.project2.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Period;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public ResponseEntity<ArrayList<Category>> getCategory(){
        return ResponseEntity.status(200).body((categoryService.getCategory()));
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseAPI> addCategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ResponseAPI(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!categoryService.addCategory(category)){
            return ResponseEntity.status(500).body(new ResponseAPI("Server error adding category",500));
        }
        return ResponseEntity.status(200).body(new ResponseAPI("Category added successfully",200));
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseAPI> updateCategory(@RequestBody @Valid Category category,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ResponseAPI(errors.getFieldError().getDefaultMessage(),400));
        }
        if(categoryService.updateCategory(category)){
            return ResponseEntity.status(200).body(new ResponseAPI("Category updated",200));
        }
        return ResponseEntity.status(400).body(new ResponseAPI("Category not found",400));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseAPI> deleteCategory(@PathVariable String id){
        if(categoryService.deleteCategory(id)){
            return ResponseEntity.status(200).body(new ResponseAPI("Category deleted",200));
        }
        return ResponseEntity.status(400).body(new ResponseAPI("Category not found",400));
    }

}
