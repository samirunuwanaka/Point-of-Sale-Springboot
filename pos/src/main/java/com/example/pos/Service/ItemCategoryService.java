package com.example.pos.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pos.entity.ItemCategory;

@Service
public interface ItemCategoryService {
    List<ItemCategory> getItemCategories();
    ItemCategory createItemCategory(ItemCategory itemCategory);
    ItemCategory updateItemCategory(String itemCategory, Long itemCategoryId);
    void deleteItemCategory(Long itemCategoryId);
    ItemCategory getItemCategoryById(Long category);
    ItemCategory getCategory(String category);
}