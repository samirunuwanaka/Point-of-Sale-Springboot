package com.example.pos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
public class Reciept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recieptId;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item")
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "purchaseID")
    private Long purchaseID;

    private int qty;
}
