package com.example.pos.Controller.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.Controller.PlaceOrderController;
import com.example.pos.Controller.StockController;
import com.example.pos.Dto.PurchaseDto;
import com.example.pos.Service.ItemService;
import com.example.pos.Service.PurchaseService;
import com.example.pos.Service.RecieptService;
import com.example.pos.entity.Purchase;
import com.example.pos.entity.Reciept;

@RestController
public class PlaceOrderControllerImpl implements PlaceOrderController {
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private RecieptService recieptService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private StockController stockController;

    @Override
    public ResponseEntity<Purchase> addPurchase(PurchaseDto[] purchaseDto) {
        try {
            Purchase purchase = new Purchase();
            Float totalPrice = 0f;
            for(PurchaseDto dto:purchaseDto){
                recieptService.createReciept(new Reciept(null, itemService.getItemByname(dto.getItem()), purchase.getPurchaseID(), dto.getQty()));
                totalPrice+=(dto.getItemWisePrice()*dto.getQty());
                stockController.changeStock(itemService.getItemByname(dto.getItem()).getItemId(), dto.getQty());
            }
            purchase.setPrice(totalPrice);
            purchase.setDate(new Date());
            
            return ResponseEntity.status(200).body(purchaseService.createPurchase(purchase));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}
