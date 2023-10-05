package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Clients;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ClientsDTO;

import com.example.demo.repository.ClientsRepository;
import com.example.demo.util.Converter;

@Service
public class ClientsServiceImpl implements ClientsService{

	@Autowired
	private ClientsRepository clientsRepository;
	
	@Autowired
	private Converter converter;
	@Override
	public ClientsDTO createClients(Clients clients) {
		Clients client = clientsRepository.save(clients);
		return converter.convertToClientsDTO(client);
		
	}

	@Override
	public List<ClientsDTO> getAllClients() {
		List<Clients> clients = clientsRepository.findAll();
		
		//list of type DTO
				List<ClientsDTO> dtoList=new ArrayList<>();
				for(Clients s:clients)
				{
					dtoList.add(converter.convertToClientsDTO(s));
				}
				
				return dtoList;
	}

	@Override
	public ClientsDTO getClientsById(int id) {
		Clients s=clientsRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Clients", "Id", id));
		return converter.convertToClientsDTO(s);
	}

	@Override
	public ClientsDTO updateClients(int id, Clients Client) {
		Clients s=clientsRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Clients", "Id", id));
		s.setName(Client.getName());
		s.setAddress(Client.getAddress());
		s.setPhNo(Client.getPhNo());
		//s.setAadharCard(Client.getAadharCard());
		
		
		
		Clients client=clientsRepository.save(s);
		return converter.convertToClientsDTO(client);
	}

	@Override
	public String deleteClients(int id) {
		clientsRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Clients", "Id", id));
		
		clientsRepository.deleteById(id);
		return "Students got deleted successfully!!";
	}

}
