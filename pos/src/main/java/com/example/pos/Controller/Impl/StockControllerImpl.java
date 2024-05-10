package com.example.pos.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.Controller.StockController;
import com.example.pos.Service.StockService;
import com.example.pos.entity.Stock;

@RestController
public class StockControllerImpl implements StockController {

    @Autowired
    private StockService stockService;

    @Override
    public Stock editStock(Long itemId, int qty) {
        return changeStock(itemId, qty);
    }

    @Override
    public Stock changeStock(Long itemId, int qty) {
        return stockService.updateStock(qty, itemId);
    }
}