package com.example.demo.model;


import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.entities.Advocate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientsDTO {

	@NotNull
	private int id;
	@NotNull
	@Size(min=3,max=50,message = "Name should have min 2 to max 50 characters")
	private String name;
	@NotNull
	@Size(min=4,max=100)
	private String address;
	@NotNull
	@Size(min=0,max=10)
    private String phNo;
	
	@NotNull
	@Size(min=0,max=12)
	private String adharCard;
	
	private boolean status=Boolean.TRUE;
	
	private Advocate advocate;
	
}
