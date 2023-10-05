package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Advocate;
import com.example.demo.entities.Clients;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AdvocateDTO;
import com.example.demo.repository.AdvocateRepository;
import com.example.demo.repository.ClientsRepository;
import com.example.demo.util.Converter;
@Service
public class AdvocateServiceImpl implements AdvocateService {
	@Autowired
	private AdvocateRepository advocateRepository; 

	@Autowired
	private ClientsRepository clientsRepository;
	
	@Autowired
	private Converter converter;
	
	@Override
	public AdvocateDTO registerAdvocate(Advocate advocate) {
	
		return converter.convertToAdvocateDTO(advocateRepository.save(advocate));
	}

	@Override
	public String assignClientsToAdvocate(int aid, int cid) {
		Clients s=clientsRepository.findById(cid).orElseThrow(()->
		new ResourceNotFoundException("Clients", "Id", cid));
		
		Advocate  t=advocateRepository.findById(aid).orElseThrow(()->
		new ResourceNotFoundException("Advocate", "Id", aid));
		
		List<Clients> clients=new ArrayList<>();
		clients.add(s);
		
		//assign students to teacher
		t.setClients(clients);
		
		//assign teacher to student
		s.setAdvocate(t);
		
		advocateRepository.save(t);
		return "Client assigned to Advocate successfully";
	
	}
}
