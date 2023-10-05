package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Advocate;
import com.example.demo.entities.Clients;
import com.example.demo.model.AdvocateDTO;
import com.example.demo.model.ClientsDTO;
import com.example.demo.service.AdvocateService;
import com.example.demo.util.Converter;



@RestController
@RequestMapping
public class AdvocateController {

	@Autowired
	private AdvocateService  advocateService;
	
	@Autowired
	private Converter converter;
	
	@PostMapping("/createAdvocate")	
	 ResponseEntity<AdvocateDTO> registerAdvocate(@Valid @RequestBody AdvocateDTO advocateDTO)	
	 {
		final Advocate advocate=converter.convertToAdvocateEntity(advocateDTO);
		return new ResponseEntity<AdvocateDTO>(advocateService.registerAdvocate(advocate),HttpStatus.CREATED); 
	 }
	
	
	@PostMapping("/assignment/{aid}/{cid}")
	public String assignClientsToAdvocate(@PathVariable("aid") int aid,
			@PathVariable("cid") int cid)
	{
		return advocateService.assignClientsToAdvocate(aid, cid);
	}
}