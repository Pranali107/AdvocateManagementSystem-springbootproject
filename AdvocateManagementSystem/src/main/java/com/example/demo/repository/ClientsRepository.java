package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Clients;

public interface ClientsRepository extends JpaRepository<Clients, Integer>{

}
