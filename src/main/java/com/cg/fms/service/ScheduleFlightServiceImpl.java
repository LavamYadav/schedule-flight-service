package com.cg.fms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dto.Flight;
import com.cg.fms.dto.Schedule;
import com.cg.fms.dto.ScheduleFlight;
import com.cg.fms.exceptions.ScheduleFlightException;
import com.cg.fms.repository.FlightRepository;
import com.cg.fms.repository.ScheduleFlightRepository;
import com.cg.fms.repository.ScheduleRepository;

@Service
public class ScheduleFlightServiceImpl implements ScheduleFlightService {
		
		@Autowired
		private ScheduleFlightRepository scheduleFlightRepository;
		
		@Autowired
		private ScheduleRepository scheduleRepository;
		
		@Autowired
		private FlightRepository flightRepository;
		private static final Logger logger = LoggerFactory.getLogger(ScheduleFlightService.class);

		@Override
		public ScheduleFlight addScheduleFlight(ScheduleFlight scheduleFlight) throws ScheduleFlightException{
			scheduleFlightRepository.save(scheduleFlight);
			return scheduleFlight;
		}

		@Override
		public List<ScheduleFlight> viewScheduleFlights() throws ScheduleFlightException {
			
			List<ScheduleFlight> scheduleFlight = (List<ScheduleFlight>) scheduleFlightRepository.findAll();
			
			if(scheduleFlight.isEmpty())
				throw new ScheduleFlightException("Scheduled  flights not found!");
			
			
			return scheduleFlight;
		}


		@Override
		public ScheduleFlight viewScheduleFlightsById(int flightId) throws ScheduleFlightException{
			logger.info("Viewing Schedule By Id");
			Optional<Flight> flight = flightRepository.findById(BigInteger.valueOf(flightId));
			Optional<ScheduleFlight> scheduleFlight = scheduleFlightRepository.findById(flightId);
			if(!scheduleFlight.isPresent())
			{
				logger.error("Flight No. "+flightId + " not Scheduled");
				throw new ScheduleFlightException("Flight No. "+flightId + " not Scheduled");
			}
			logger.info("Viewing Schedule By Id");	
			return scheduleFlight.get();
		}

		@Override
		public List<ScheduleFlight> viewScheduleFlight() throws ScheduleFlightException{
			logger.info("Viewing Schedule list");
			List<ScheduleFlight> scheduleFlightList = new ArrayList<>();
			scheduleFlightRepository.findAll().forEach(ScheduleFlight1 -> scheduleFlightList.add(ScheduleFlight1));
			if(scheduleFlightList.isEmpty())
			{
				logger.error("Schedule not found");
				throw new ScheduleFlightException("No Schdeule Flight Found");
			}
			logger.info("Viewing Schedule list");
			return scheduleFlightList;
		}

		@Override
		public ScheduleFlight modifyScheduleFlight(ScheduleFlight scheduleFlight) throws ScheduleFlightException{
		
			logger.info("Modifying Schedule flight");
			Optional<ScheduleFlight> scheduleFlightUpdate = scheduleFlightRepository.findById(scheduleFlight.getScheduleFlightId());
			if(!scheduleFlightUpdate.isPresent())
			{
				logger.error("Viewing Schedule list Scheduled flight with ID:"+scheduleFlight.getScheduleFlightId() +" not found");
				throw new ScheduleFlightException("Scheduled flight with ID: "+scheduleFlight.getScheduleFlightId() +" not found");

			}
			scheduleFlightUpdate.get().setSchedule(scheduleFlight.getSchedule());
			scheduleFlightUpdate.get().setTicketCost(scheduleFlight.getTicketCost());
			scheduleFlightRepository.save(scheduleFlightUpdate.get());
			logger.info("Modifying Schedule file");
			return scheduleFlightUpdate.get();
		}

		
		@Override
		public void deleteScheduleFlight(int flightId) throws ScheduleFlightException {
			logger.info("Deleting Schedule flight");
			Optional<Flight> flight = flightRepository.findById(BigInteger.valueOf(flightId));
			Optional<ScheduleFlight> scheduleFlight = scheduleFlightRepository.findById(flightId);
//			if(!flight.isPresent())
//			{
//				logger.error("Flight not found");
//				throw new ScheduleFlightException("Flight not found");
//			}
			 if(!scheduleFlight.isPresent()) {
				logger.error("Flight No. "+flightId + " not Scheduled");
				throw new ScheduleFlightException("Flight No. "+flightId + " not Scheduled");
			}
			scheduleFlightRepository.deleteById(flightId);
		}

		@Override
		public void validateScheduledFlight(ScheduleFlight scheduleflight) {
			
			return;
		}

		


}
