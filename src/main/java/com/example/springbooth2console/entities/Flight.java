package com.example.springbooth2console.entities;


import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Flight {
	public Flight() {}
	public Flight(Long numVol, Date dateDepart, Date dateArrive, String avion, int prix, int nbrePlace,
			int nbrePlaceRestant, String villeDepart, String villeArrive) {
		this.numVol = numVol;
		this.dateDepart = dateDepart;
		this.dateArrive = dateArrive;
		this.avion = avion;
		this.prix = prix;
		this.nbrePlace = nbrePlace;
		this.nbrePlaceRestant = nbrePlaceRestant;
		this.villeDepart = villeDepart;
		this.villeArrive = villeArrive;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long numVol;
	public Date dateDepart;
	public Date dateArrive;
	public String avion;
	public int prix;
	public int nbrePlace;
	public int nbrePlaceRestant;
	public String villeDepart;
	public String villeArrive;
	@OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    private List<Reservation> listReservations;


}