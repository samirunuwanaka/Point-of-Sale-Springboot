package com.example.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos.entity.Item;


public interface ItemRepository extends JpaRepository<Item, Long>{

}