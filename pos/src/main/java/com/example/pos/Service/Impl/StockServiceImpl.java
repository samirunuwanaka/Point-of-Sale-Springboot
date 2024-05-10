package com.example.pos.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.Service.StockService;
import com.example.pos.entity.Stock;
import com.example.pos.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock createStock(Stock stock) {
        // TODO Auto-generated method stub
        return stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Long stockId) {
        // TODO Auto-generated method stub
        stockRepository.deleteById(stockId);
    }

    @Override
    public List<Stock> getStocks() {
        // TODO Auto-generated method stub
        return stockRepository.findAll();
    }

    @Override
    public Stock getStock(Long itemId) {
        return stockRepository.findById(itemId).orElse(null);
    }

    @Override
    public Stock updateStock(int qty, Long stockId) {

        Stock esistStock = stockRepository.findById(stockId).orElse(null);

        if (esistStock == null) {
            return null;
        }

        esistStock.setQty(qty);
        // TODO Auto-generated method stub
        return stockRepository.save(esistStock);
    }
}
