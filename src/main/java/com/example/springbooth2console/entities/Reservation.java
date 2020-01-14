package com.example.springbooth2console.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {
	public Reservation() {};
	public Reservation(Long id, Long numVol, Date dateRes, int nbrePlace, Customer customer) {
		this.id = id;
		this.numVol = numVol;
		this.dateRes = dateRes;
		this.nbrePlace = nbrePlace;
		this.customer = customer;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
	public Long numVol;
	public Date dateRes;
	public int nbrePlace;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer")
    public Customer customer;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "flight")
    public Flight flight;
    
    
}