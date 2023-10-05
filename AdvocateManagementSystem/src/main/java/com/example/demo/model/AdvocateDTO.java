package com.example.demo.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.example.demo.entities.Clients;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdvocateDTO {

	@NotNull
	private int id;
	
	@NotNull
	@Size(min=3,max=50,message = "Name should have min 2 to max 50 characters")
	private String name;
	
	@NotNull
	@Size(min=5,max=100,message = "Name should have min 2 to max 50 characters")
	private String address;
	  
	@NotNull
	@Size(min=0,max=10,message = "Name should have min 2 to max 50 characters")
	private String phNo;
	
	
	@NotNull
	@Size(min=2,max=50,message = "Name should have min 2 to max 50 characters")
	private String qualification;
	
	private boolean status=Boolean.TRUE;
	
	List<Clients> clients;
}
