package com.cg.fms.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.fms.dto.Flight;
import com.cg.fms.dto.ScheduleFlight;

import java.math.BigInteger;

public interface ScheduleFlightRepository extends CrudRepository<ScheduleFlight, Integer> {
	ScheduleFlight findByFlight(Flight flight);
}
