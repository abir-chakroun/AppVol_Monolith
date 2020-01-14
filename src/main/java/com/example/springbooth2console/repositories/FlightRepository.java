package com.example.springbooth2console.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbooth2console.entities.Flight;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{

}
