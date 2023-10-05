package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Clients;

import com.example.demo.model.ClientsDTO;

import com.example.demo.repository.ClientsRepository;
import com.example.demo.service.ClientsService;
import com.example.demo.util.Converter;

@RestController
@RequestMapping
public class ClientsController {

	@Autowired
	private ClientsService clientsService;
	
	@Autowired
	private Converter converter;
	@PostMapping("/createClients")	
	 ResponseEntity<ClientsDTO> createClients(@Valid @RequestBody ClientsDTO clientsDTO)	
	 {
		final Clients client=converter.convertToClientsEntity(clientsDTO);
		return new ResponseEntity<ClientsDTO>(clientsService.createClients(client),HttpStatus.CREATED); 
	 }
	@GetMapping("/getAllClients")
	List<ClientsDTO> getAllClients()
	{
		return clientsService.getAllClients();
	}
	
	@GetMapping("/getStudentById/{cid}")
	ClientsDTO getStudentById(@PathVariable("cid") int id)
   {
	   return clientsService.getClientsById(id);
   }
	
	@PutMapping("/updateClients/{id}")
	ClientsDTO	updateClients(@Valid @PathVariable int id,@RequestBody ClientsDTO clientsDTO)
{
		final Clients client=converter.convertToClientsEntity(clientsDTO);
	return clientsService.updateClients(id, client);
}
	@DeleteMapping("/deleteClients/{id}")
	String deleteClients(@PathVariable int id)
	{
		return clientsService.deleteClients(id);
	}
}
	

