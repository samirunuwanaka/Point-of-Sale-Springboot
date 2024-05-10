package com.example.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long >{

}
