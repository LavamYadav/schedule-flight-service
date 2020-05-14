package com.cg.fms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

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
	private BigInteger flightNumber;

	@NotEmpty(message = "Flight Model is Empty")
	private String flightModel;

	@NotEmpty(message = "Carrier Name is Empty")
	private String carrierName;

	private int seatCapacity;

	public Flight() {
		super();

	}
	
	public BigInteger getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(BigInteger flightNumber) {
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
