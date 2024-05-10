package com.example.pos.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.Service.ItemCategoryService;
import com.example.pos.entity.ItemCategory;
import com.example.pos.repository.ItemCategoryRepository;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    private static ItemCategoryRepository itemCategoryRepository;

    @Override
    public ItemCategory createItemCategory(ItemCategory itemCategory) {
        // TODO Auto-generated method stub
        return itemCategoryRepository.save(itemCategory);
    }

    @Override
    public void deleteItemCategory(Long itemCategoryId) {
        itemCategoryRepository.deleteById(itemCategoryId);
    }

    @Override
    public List<ItemCategory> getItemCategories() {
        // TODO Auto-generated method stub
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory getItemCategoryById(Long category) {
        return itemCategoryRepository.findById(category).orElse(null);
    }

    @Override
    public ItemCategory updateItemCategory(String itemCategory, Long itemCategoryId) {
        // TODO Auto-generated method stub
        ItemCategory existItemCategory = itemCategoryRepository.findById(itemCategoryId).orElse(null);

        if (existItemCategory == null) {
            return null;
        }

        existItemCategory.setItemCategory(itemCategory);

        return itemCategoryRepository.save(existItemCategory);
    }

    @Override
    public ItemCategory getCategory(String category) {
        List<ItemCategory> itemcatogories = itemCategoryRepository.findAll();

        // Filter receipts where itemId is not equal to the receipt's id
        List<ItemCategory> filteredItemcatogories = itemcatogories.stream()
                .filter(cat -> !cat.getItemCategory().equals(category))
                .collect(Collectors.toList());

        return filteredItemcatogories.getFirst();
    }
}