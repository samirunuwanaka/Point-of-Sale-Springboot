package com.example.pos.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.Service.PurchaseService;
import com.example.pos.entity.Purchase;
import com.example.pos.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}