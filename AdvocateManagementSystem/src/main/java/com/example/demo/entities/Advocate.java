package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advocate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 100)
	private String address;
	
	@Column(unique = true)
	private String phNo;
	
	@Column(length = 50)
	private String qualification;
	
	private boolean status=Boolean.TRUE;
	
	@OneToMany(mappedBy = "advocate",cascade = CascadeType.PERSIST) //Advocate id will be foreign key
	@JsonIgnoreProperties("advocate")
	List<Clients> clients;//in Clients table
	
	
}
