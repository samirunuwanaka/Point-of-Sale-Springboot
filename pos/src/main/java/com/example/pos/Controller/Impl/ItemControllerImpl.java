package com.example.pos.Controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.Controller.ItemController;
import com.example.pos.Dto.ItemCategoryDto;
import com.example.pos.Service.ItemCategoryService;
import com.example.pos.Service.ItemService;
import com.example.pos.Service.RecieptService;
import com.example.pos.Service.StockService;
import com.example.pos.entity.Item;
import com.example.pos.entity.ItemCategory;
import com.example.pos.entity.Stock;

@RestController
public class ItemControllerImpl implements ItemController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private StockService stockService;

    @Autowired
    private RecieptService recieptService;

    @Override
    public ResponseEntity<ItemCategory> createCtegory(String category) {
        ItemCategory itemCategory = new ItemCategory();
        itemCategory.setItemCategory(category);
        try {
            return ResponseEntity.status(200).body(itemCategoryService.createItemCategory(itemCategory));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @Override
    public ResponseEntity<Item> createItem(ItemCategoryDto itemCategoryDto) {
        Stock stock = new Stock();
        Item item = new Item(itemCategoryDto.getItemCategoryId(), itemCategoryDto.getItem(), itemCategoryDto.getPrice(), itemCategoryService.getItemCategoryById(itemCategoryDto.getItemCategoryId()), null, null);
        stock.setItem(item);
        
        stock = stockService.createStock(stock);

        item.setStocks(stock);

        itemService.createItem(item);

        try {
            return ResponseEntity.status(200).body(itemService.createItem(item));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @Override
    public List<ItemCategory> getItemCategories() {
        return itemCategoryService.getItemCategories();
    }

    @Override
    public ResponseEntity<Item[]> updateItem(ItemCategoryDto itemCategoryDto) {
        try {
            Item[] item = {itemService.updateItem(
                new Item(itemCategoryDto.getItemCategoryId(), itemCategoryDto.getItem(), itemCategoryDto.getPrice(), itemCategoryService.getCategory(itemCategoryDto.getItemCategory()), stockService.getStock(itemCategoryDto.getItemCategoryId()), recieptService.getByItem(itemCategoryDto.getItemCategoryId()))
            , itemCategoryDto.getItemCategoryId())};
            return ResponseEntity.status(200).body(item);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @Override
    public ResponseEntity<ItemCategory> updateItemCategory(Long itemCategoryId, String itemCategory) {
        try {
            return ResponseEntity.status(200).body(
                itemCategoryService.updateItemCategory(itemCategory, itemCategoryId)
            );
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @Override
    public ResponseEntity<Item> deleteItem(Long itemId) {
        try {
            itemService.deleteItem(itemId);
            return ResponseEntity.status(200).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }
    
    @Override
    public ResponseEntity<ItemCategory> deleteCategory(Long itemCategoryId) {
        try {
            itemCategoryService.deleteItemCategory(itemCategoryId);
            return ResponseEntity.status(200).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

}