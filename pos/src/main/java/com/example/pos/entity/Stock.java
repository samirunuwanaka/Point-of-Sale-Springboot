package com.example.pos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stock {
    @Id
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "itemId")
    private Item item;

    private int qty;
}
