package com.example.pos.Service;

import java.util.List;

import com.example.pos.entity.Stock;

public interface StockService {
    List<Stock> getStocks();
    Stock getStock(Long itemId);
    Stock createStock(Stock stock);
    Stock updateStock(int qty, Long stockId);
    void deleteStock(Long stockId);
}
