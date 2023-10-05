package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Clients;
import com.example.demo.model.ClientsDTO;

public interface ClientsService {
	ClientsDTO createClients(Clients Clients);
	List<ClientsDTO> getAllClients();
	ClientsDTO getClientsById(int id);
	ClientsDTO updateClients(int id, Clients Client);
	String deleteClients(int id);

	
}
