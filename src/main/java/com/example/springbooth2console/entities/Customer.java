package com.example.springbooth2console.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

	public Customer() {}
	public Customer(Long id, String firstName, String lastName, String cin, String age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cin = cin;
		this.age = age;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
    public String firstName;
    public String lastName;
    public String cin;
    public String age;
    
    @OneToMany(mappedBy="customer",fetch=FetchType.LAZY)
    private List<Reservation> reservations;
   
    
}
