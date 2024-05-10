package com.example.pos.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pos.entity.Item;

@Service
public interface ItemService {
    List<Item> getItems();
    Item getItemByname(String item);
    Item createItem(Item item);
    Item updateItem(Item item, Long itemId);
    void deleteItem(Long itemId);
}