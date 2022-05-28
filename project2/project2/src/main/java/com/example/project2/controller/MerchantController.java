package com.example.project2.controller;

import com.example.project2.model.Category;
import com.example.project2.model.Merchant;
import com.example.project2.model.Product;
import com.example.project2.model.ResponseAPI;
import com.example.project2.service.MerchantService;
import com.example.project2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;
    @GetMapping
    public ResponseEntity<ArrayList<Merchant>> getMerchants(){
        return ResponseEntity.status(200).body((merchantService.getMerchants()));
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseAPI> addMerchant(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ResponseAPI(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!merchantService.addMerchants(merchant)){
            return ResponseEntity.status(500).body(new ResponseAPI("Server error adding a Merchant",500));
        }
        return ResponseEntity.status(200).body(new ResponseAPI("Merchant added successfully",200));
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseAPI> updateMerchant(@RequestBody @Valid Merchant merchant,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ResponseAPI(errors.getFieldError().getDefaultMessage(),400));
        }
        if(merchantService.updateMerchants(merchant)){
            return ResponseEntity.status(200).body(new ResponseAPI("Merchant updated",200));
        }
        return ResponseEntity.status(400).body(new ResponseAPI("Merchant not found",400));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseAPI> deleteMerchant(@PathVariable String id){
        if(merchantService.deleteMerchant(id)){
            return ResponseEntity.status(200).body(new ResponseAPI("Merchant deleted",200));
        }
        return ResponseEntity.status(400).body(new ResponseAPI("Merchant not found",400));
    }
    @PutMapping("/addstock/{merchantID}/{stock}")
    public  ResponseEntity<ResponseAPI> addStock(@PathVariable String merchantID,@PathVariable Integer stock){
        if(merchantService.addStock(merchantID,stock)){
            return ResponseEntity.status(200).body(new ResponseAPI("Stock updated",200));
        }
        return ResponseEntity.status(400).body(new ResponseAPI("Merchant not found",400));
    }

}
