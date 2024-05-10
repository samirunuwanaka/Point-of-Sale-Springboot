package com.example.pos.Service;

import java.util.List;

import com.example.pos.entity.Reciept;

public interface RecieptService {
    Reciept createReciept(Reciept reciept);
    public List<Reciept> getByItem(Long itemId);
}