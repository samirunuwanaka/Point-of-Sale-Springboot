package com.example.pos.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.entity.Stock;

@RestController
@CrossOrigin(origins = "http://localhost:8080", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public interface StockController {
    @PostMapping("http://localhost:8080/set stock/{itemId}")
    public Stock editStock(@PathVariable Long itemId , @RequestBody int qty);

    public Stock changeStock(Long itemId, int qty);
}