package com.cg.fms.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.fms.dto.ScheduleFlight;
import com.cg.fms.exceptions.ScheduleFlightException;
import com.cg.fms.payload.RestResponse;
import com.cg.fms.service.ScheduleFlightService;

/**
 * @author Lavam
 *
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleFlightController {

	@Autowired
	ScheduleFlightService scheduleFlightService;

	
	
	/*
	 * Author: Lavam Description: Will Add The New Schedule Details 
	 *  
	 */
	@PostMapping(value = "/addScheduleFlight")
	public ResponseEntity<?> addScheduleFlight(@Valid @RequestBody ScheduleFlight scheduleFlight) {
		
		try {
			return ResponseEntity.ok(new RestResponse<>(true, "Schedule Added", scheduleFlightService.addScheduleFlight(scheduleFlight)));
		} catch (ScheduleFlightException e) {
			return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		}
		
	}

	/*
	 * Author: Lavam Description: Will Show All Schedule Details 
	 *  
	 */
	  @GetMapping(value = "/showScheduleData") 
	  public ResponseEntity<?> viewScheduleFlights()
	  { 
		  try {
			return ResponseEntity.ok(new RestResponse<>(true, "Schedule Found", scheduleFlightService.viewScheduleFlight()));
	} catch (ScheduleFlightException e) {
		
		return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		
	}
	 }
	  
	
	  /*
	   * Author: Lavam Description: Will Show  Schedule Details By Id
	   *  
	  */

	@GetMapping(value = "/showDatabyId/{scheduleFlightId}")
	public ResponseEntity<?> viewScheduleFlights(@PathVariable("scheduleFlightId") int scheduleFlightId) {
		try {
			return ResponseEntity.ok(new RestResponse<>(true, "Schedule Found", scheduleFlightService.viewScheduleFlightsById(scheduleFlightId)));
		} catch (ScheduleFlightException e) {
			
			return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		}
	
	}

	
	 /*
	 * Author: Lavam Description: Will Delete  Schedule Details By Id
	 *  
	 */
	@DeleteMapping("/deleteScheduleSlight/{scheduleFlightId}")
	public ResponseEntity<?> deleteScheduleFlightById(@PathVariable("scheduleFlightId") int scheduleFlightId) {
		try {
			scheduleFlightService.deleteScheduleFlight(scheduleFlightId);
			return ResponseEntity.ok(new RestResponse<>(true, "Schedule Deleted")); 
		} catch (ScheduleFlightException e) {
			return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		}
	}

	
	 /*
	  * Author: Lavam Description: Will Modify  Schedule Details By Id
	  *  
	 */
	@PutMapping("/modifyScheduleFlight")
	private ResponseEntity<?> modifyScheduleFlight(ScheduleFlight scheduleFlight) {
		try {
			return ResponseEntity.ok(new RestResponse<>(true, "Schedule Modified", scheduleFlightService.modifyScheduleFlight(scheduleFlight)));
		} catch (ScheduleFlightException e) {
			
			return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		}
		
	}

}

