package com.cg.fms.dto;

import javax.persistence.*;

/**
 * @author Lavam
 * description: ScheduleFlight Model
 */
@Entity
@Table
public class ScheduleFlight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scheduleFlightId;

	@OneToOne(fetch = FetchType.EAGER)
	private Flight flight;

	
	private int availableSeats;

	@OneToOne(cascade = CascadeType.ALL)
	private Schedule schedule;

	
	private Double ticketCost;

	
	private Boolean scheduleFlightState;

	public ScheduleFlight() {
		super();
		
	}

	public int getScheduleFlightId() {
		return scheduleFlightId;
	}

	public void setScheduleFlightId(int scheduleFlightId) {
		this.scheduleFlightId = scheduleFlightId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(Double ticketCost) {
		this.ticketCost = ticketCost;
	}

	public Boolean getScheduleFlightState() {
		return scheduleFlightState;
	}

	public void setScheduleFlightState(Boolean scheduleFlightState) {
		this.scheduleFlightState = scheduleFlightState;
	}

}
