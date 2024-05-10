package com.example.pos.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToMany(mappedBy = "purchase")
    private Long purchaseID;

    private Date date;
    private float price;
}
