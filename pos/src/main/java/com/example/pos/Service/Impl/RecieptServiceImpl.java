package com.example.pos.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.Service.RecieptService;
import com.example.pos.entity.Reciept;
import com.example.pos.repository.RecieptRepository;

@Service
public class RecieptServiceImpl implements RecieptService {
    @Autowired
    private RecieptRepository recieptRepository;

    @Override
    public Reciept createReciept(Reciept reciept) {
        return recieptRepository.save(reciept);
    }

    public List<Reciept> getByItem(Long itemId) {
        List<Reciept> receipts = recieptRepository.findAll();

        // Filter receipts where itemId is not equal to the receipt's id
        List<Reciept> filteredReceipts = receipts.stream()
                .filter(receipt -> !receipt.getItem().getItemId().equals(itemId))
                .collect(Collectors.toList());

        return filteredReceipts;
    }

}