package com.example.project2.controller;

import com.example.project2.model.Category;
import com.example.project2.model.Merchant;
import com.example.project2.model.MerchantStock;
import com.example.project2.model.ResponseAPI;
import com.example.project2.service.MerchantService;
import com.example.project2.service.MerchantStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchantstock")
@RequiredArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStockService;
    @GetMapping
    public ResponseEntity<ArrayList<MerchantStock>> getMerchantStocks(){
        return ResponseEntity.status(200).body((merchantStockService.getMerchantStocks()));
    }
    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ResponseAPI(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!merchantStockService.addMerchantStocks(merchantStock)){
            return ResponseEntity.status(500).body(new ResponseAPI("Server error adding a Merchant Stock",500));
        }
        return ResponseEntity.status(200).body(new ResponseAPI("Merchant Stock added successfully",200));
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseAPI> updateMerchantStock(@RequestBody @Valid MerchantStock merchantStock,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ResponseAPI(errors.getFieldError().getDefaultMessage(),400));
        }
        if(merchantStockService.updateMerchantStocks(merchantStock)){
            return ResponseEntity.status(200).body(new ResponseAPI("Merchant Stock updated",200));
        }
        return ResponseEntity.status(400).body(new ResponseAPI("Merchant Stock not found",400));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseAPI> deleteMerchantStock(@PathVariable String id){
        if(merchantStockService.deleteMerchantStock(id)){
            return ResponseEntity.status(200).body(new ResponseAPI("Merchant Stock deleted",200));
        }
        return ResponseEntity.status(400).body(new ResponseAPI("Merchant Stock not found",400));
    }

}
