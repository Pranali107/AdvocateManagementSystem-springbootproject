package com.example.demo.service;


import com.example.demo.entities.Advocate;
import com.example.demo.model.AdvocateDTO;


public interface AdvocateService {
	String assignClientsToAdvocate(int aid,int cid);
	AdvocateDTO registerAdvocate(Advocate advocate);

}
