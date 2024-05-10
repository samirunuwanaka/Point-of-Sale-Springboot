package com.example.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
