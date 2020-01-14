package com.example.springbooth2console.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbooth2console.entities.Customer;
import com.example.springbooth2console.entities.Reservation;
import com.example.springbooth2console.repositories.ReservationRepository;



@RestController
@RequestMapping(value="/Reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping(value = "/List", method = RequestMethod.GET)
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @RequestMapping(value="/Create",method=RequestMethod.POST)
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation r) {
    	Customer cust = new Customer(r.customer.id, r.customer.firstName, r.customer.lastName, r.customer.cin, r.customer.age);
    	Reservation res = new Reservation (r.id, r.numVol, r.dateRes, r.nbrePlace, cust);
        reservationRepository.save(res);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    
}