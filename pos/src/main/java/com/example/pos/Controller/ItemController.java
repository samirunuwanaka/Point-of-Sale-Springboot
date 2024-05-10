package com.example.pos.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.Dto.ItemCategoryDto;
import com.example.pos.entity.Item;
import com.example.pos.entity.ItemCategory;

@RestController
@CrossOrigin(origins = "http://localhost:8080", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public interface ItemController {
    @GetMapping("http://localhost:8080/get categories")
    public List<ItemCategory> getItemCategories();

    @PostMapping("http://localhost:8080/set category/{itemCategoryId}")
    public ResponseEntity<ItemCategory> updateItemCategory(@PathVariable Long itemCategoryId,@RequestBody String itemCategory);

    @PostMapping("http://localhost:8080/set item")
    public ResponseEntity<Item[]> updateItem(@RequestBody ItemCategoryDto itemCategoryDto/*
        item, price, itemCategory
    */);

    @DeleteMapping("http://localhost:8080/item delete/{itemId}")
    public ResponseEntity<Item> deleteItem(@PathVariable Long itemId);

    @DeleteMapping("http://localhost:8080/category delete/{itemCategoryId}")
    public ResponseEntity<ItemCategory> deleteCategory(@PathVariable Long itemCategoryId);

    @PutMapping("http://localhost:8080/add category")
    public ResponseEntity<ItemCategory> createCtegory(@RequestBody String itemCategory);

    @PutMapping("http://localhost:8080/add item")
    public ResponseEntity<Item> createItem(@RequestBody ItemCategoryDto itemCategoryDto/*
        item, price, itemCategory
    */);
}