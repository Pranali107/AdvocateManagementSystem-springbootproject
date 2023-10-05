package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Advocate;

public interface AdvocateRepository extends JpaRepository<Advocate, Integer>{

}
