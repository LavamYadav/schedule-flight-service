package com.cg.fms.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.fms.dto.Flight;

import java.math.BigInteger;

public interface FlightRepository extends CrudRepository<Flight, BigInteger> {

}
