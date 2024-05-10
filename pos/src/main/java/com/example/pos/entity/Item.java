package com.example.pos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String item;

    private float price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "itemCategoryId")
    private ItemCategory itemCategory;

    @OneToOne(mappedBy = "Item")
    private Stock stocks;

    @JsonIgnore
    @OneToOne(mappedBy = "Item")
    private List<Reciept> reciepts;
}
