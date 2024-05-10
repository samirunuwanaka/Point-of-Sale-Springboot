package com.example.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos.entity.Reciept;

public interface RecieptRepository extends JpaRepository<Reciept, Long > {

}