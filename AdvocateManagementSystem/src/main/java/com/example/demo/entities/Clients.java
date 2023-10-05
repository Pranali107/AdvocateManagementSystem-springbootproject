package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clients {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	private String name;
	@Column(length = 100)
	private String address;
	@Column(unique = true)
	@Size(min=0,max=10)
    private String phNo;
	@Column(unique = true)
	@Size(min=0,max=12)
	private String adharCard;
	
	
	
	private boolean status=Boolean.TRUE;
	
	//many students -one teacher
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "aId")
	@JsonIgnoreProperties("clients")
	
	
	private Advocate advocate;
	
}
