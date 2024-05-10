package com.example.pos.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PurchaseDto {
    private String item;
    private int qty;
    private float itemWisePrice;
}
