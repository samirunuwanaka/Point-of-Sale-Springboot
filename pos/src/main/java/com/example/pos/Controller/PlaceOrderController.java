package com.example.pos.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.Dto.PurchaseDto;
import com.example.pos.entity.Purchase;

@RestController
@CrossOrigin("*")
public interface PlaceOrderController {
    @PutMapping("http://localhost:8080/add purchase")
    public ResponseEntity<Purchase> addPurchase(@RequestBody PurchaseDto[] purchaseDto);
}