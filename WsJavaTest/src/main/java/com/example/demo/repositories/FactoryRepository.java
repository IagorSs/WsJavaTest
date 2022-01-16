package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Factory;

public interface FactoryRepository extends JpaRepository<Factory, Long> {

}
