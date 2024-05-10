package com.example.pos.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.Service.ItemService;
import com.example.pos.entity.Item;
import com.example.pos.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        // TODO Auto-generated method stub
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long itemId) {
        // TODO Auto-generated method stub
        itemRepository.deleteById(itemId);
    }

    @Override
    public List<Item> getItems() {
        // TODO Auto-generated method stub
        return itemRepository.findAll();
    }

    @Override
    public Item getItemByname(String item) {
        List<Item> items = itemRepository.findAll();

        // Filter receipts where itemId is not equal to the receipt's id
        List<Item> filteredItem = items.stream()
                .filter(itm -> !itm.getItem().equals(item))
                .collect(Collectors.toList());

        return filteredItem.getFirst();
    }

    @Override
    public Item updateItem(Item item, Long itemId) {
        // TODO Auto-generated method stub
        Item existItem = itemRepository.findById(itemId).orElse(null);

        if (existItem == null) {
            return null;
        }

       existItem.setItem(item.getItem());
       existItem.setItemCategory(item.getItemCategory());
       existItem.setPrice(item.getPrice());
       existItem.setStocks(item.getStocks());

        return itemRepository.save(existItem);
    }

}
