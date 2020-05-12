package com.cg.fms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Lavam
 * description: Flight Model
 *
 */
@Entity
@Table
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "flight_number")
	private int flightNumber;

	@NotEmpty(message = "Flight Model is Empty")
	@Column(name = "flight_model")
	private String flightModel;

	@NotEmpty(message = "Carrier Name is Empty")
	@Column(name = "carrier_name")
	private String carrierName;

	@NotNull(message = "Seat Capacity is Empty")
	@Column(name = "seat_capacity")
	private int seatCapacity;

	public Flight() {
		super();

	}

	public int getFlightNumber() {
		return flightNumber;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", flightModel=" + flightModel + ", carrierName=" + carrierName
				+ ", seatCapacity=" + seatCapacity + "]";
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
}
