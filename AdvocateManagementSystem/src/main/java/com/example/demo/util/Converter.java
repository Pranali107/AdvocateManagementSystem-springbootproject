package com.example.demo.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Advocate;
import com.example.demo.entities.Clients;
import com.example.demo.model.AdvocateDTO;
import com.example.demo.model.ClientsDTO;


@Component
public class Converter {

//convert from DTO to Entity

public  Clients convertToClientsEntity(ClientsDTO ClientsDTO)
{
	Clients clients=new Clients();
	if(ClientsDTO!=null)
	{
		BeanUtils.copyProperties(ClientsDTO, clients);
	}
     return clients;
}

//convert from Entity to DTO
public ClientsDTO convertToClientsDTO(Clients clients)
{
	ClientsDTO clientsDTO=new ClientsDTO();
	if(clients!=null)
	{
		BeanUtils.copyProperties(clients, clientsDTO);
	}
	return clientsDTO;
}



//convert from DTO to Entity

public  Advocate convertToAdvocateEntity(AdvocateDTO advocateDTO)
{
	Advocate advocate=new Advocate();
	if(advocateDTO!=null)
	{
		BeanUtils.copyProperties(advocateDTO, advocate);
	}
     return advocate;
}

//convert from Entity to DTO
public AdvocateDTO convertToAdvocateDTO(Advocate advocate)
{
	AdvocateDTO advocateDTO=new AdvocateDTO();
	if(advocate!=null)
	{
		BeanUtils.copyProperties(advocate, advocateDTO);
	}
	return advocateDTO;
}
}