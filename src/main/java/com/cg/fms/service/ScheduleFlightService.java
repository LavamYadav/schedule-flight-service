package com.cg.fms.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.fms.dto.ScheduleFlight;
import com.cg.fms.exceptions.ScheduleFlightException;

public interface ScheduleFlightService {

	public ScheduleFlight addScheduleFlight(ScheduleFlight scheduleflight) throws ScheduleFlightException;

	public List<ScheduleFlight> viewScheduleFlights() throws ScheduleFlightException;

	public ScheduleFlight viewScheduleFlightsById(int flightId) throws ScheduleFlightException;

	public List<ScheduleFlight> viewScheduleFlight() throws ScheduleFlightException;

	public ScheduleFlight modifyScheduleFlight(ScheduleFlight scheduleFlight) throws ScheduleFlightException;

	public void deleteScheduleFlight(int flightId) throws ScheduleFlightException;

	void validateScheduledFlight(ScheduleFlight scheduleflight);

	

}
