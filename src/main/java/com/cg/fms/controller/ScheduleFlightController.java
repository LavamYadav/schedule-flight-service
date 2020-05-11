package com.cg.fms.controller;



import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dto.Airport;
import com.cg.fms.dto.ScheduleFlight;
import com.cg.fms.exceptions.ScheduleFlightException;
import com.cg.fms.payload.RestResponse;
import com.cg.fms.service.ScheduleFlightService;

@RestController
public class ScheduleFlightController {

	@Autowired
	ScheduleFlightService scheduleFlightService;

	@PostMapping(value = "/addSchedule")
	public ResponseEntity<?> addScheduleFlight(@RequestBody ScheduleFlight scheduleflight) {
		
		try {
			return ResponseEntity.ok(new RestResponse<>(true, "Schedule Added", scheduleFlightService.addScheduleFlight(scheduleflight)));
		} catch (ScheduleFlightException e) {
			return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		}
		
	}

	
	  @GetMapping(value = "/showdata") 
	  public ResponseEntity<?> viewScheduleFlights(@RequestBody Airport source, @RequestBody Airport
	  destination,@RequestBody LocalDateTime flightDate)
	  { 
		  try {
			return ResponseEntity.ok(new RestResponse<>(true, "Schedule Found", scheduleFlightService.viewScheduleFlight()));
	} catch (ScheduleFlightException e) {
		// TODO Auto-generated catch block
		return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		
	}
	 }
	 

	@GetMapping(value = "/showdatabyid/{scheduleFlightId}")
	public ResponseEntity<?> viewScheduleFlights(@PathVariable("scheduleFlightId") int scheduleFlightId) {
		try {
			return ResponseEntity.ok(new RestResponse<>(true, "Schedule Found", scheduleFlightService.viewScheduleFlightsById(scheduleFlightId)));
		} catch (ScheduleFlightException e) {
			
			return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		}
	
	}

	@DeleteMapping("/scheduleflight/{scheduleFlightId}")
	public ResponseEntity<?> deleteScheduleFlightById(@PathVariable("scheduleFlightId") int scheduleFlightId) {
		try {
			scheduleFlightService.deleteScheduleFlight(scheduleFlightId);
			return ResponseEntity.ok(new RestResponse<>(true, "Schedule Deleted")); 
		} catch (ScheduleFlightException e) {
			return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		}
	}

	@PutMapping("/modifyScheduleFlight")
	private ResponseEntity<?> modifyScheduleFlight(ScheduleFlight scheduleFlight) {
		try {
			return ResponseEntity.ok(new RestResponse<>(true, "Schedule Modified", scheduleFlightService.modifyScheduleFlight(scheduleFlight)));
		} catch (ScheduleFlightException e) {
			
			return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		}
		
	}

}
