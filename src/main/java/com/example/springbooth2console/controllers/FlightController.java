package com.example.springbooth2console.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbooth2console.entities.Flight;
import com.example.springbooth2console.repositories.FlightRepository;


@RestController
@RequestMapping(value="/Flight")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping(value = "/List", method = RequestMethod.GET)
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    
    @RequestMapping(value = "/List/{id}", method = RequestMethod.GET)
    public Optional<Flight> getCustomerById(@PathVariable Long id) {
        return flightRepository.findById(id);
    }
    
    @RequestMapping(value="/Create",method=RequestMethod.POST)
    public ResponseEntity<Flight> addFlight(@RequestBody Flight f) {
        Flight flight = new Flight(f.numVol, f.dateDepart, f.dateArrive, f.avion, f.prix, f.nbrePlace, f.nbrePlaceRestant, f.villeDepart, f.villeArrive);
        flightRepository.save(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/Update", method = RequestMethod.PUT)
    public Flight updateVol(@RequestBody Flight f) {
        return flightRepository.saveAndFlush(f);
    }
    
 
    

}