package com.example.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos.entity.ItemCategory;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long>{

}