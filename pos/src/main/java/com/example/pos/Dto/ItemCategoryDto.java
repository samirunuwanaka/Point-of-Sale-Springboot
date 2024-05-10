package com.example.pos.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ItemCategoryDto {
    private Long itemCategoryId;
    private String itemCategory;
    private String item;
    private float price;
    private int qty;
}
