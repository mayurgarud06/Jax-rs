package com.fis.entity;

import java.time.LocalTime;

public class Flight {
	private int flightNo;
	private String carrier;
	private String source;
	private String destination;
	private LocalTime depatureTime;
	private LocalTime arrivalTime;

	public Flight() {

	}

	public Flight(int flightNo, String carrier, String source, String destination, LocalTime depatureTime,
			LocalTime arrivalTime) {
		super();
		this.flightNo = flightNo;
		this.carrier = carrier;
		this.source = source;
		this.destination = destination;
		this.depatureTime = depatureTime;
		this.arrivalTime = arrivalTime;
	}

	

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalTime getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(LocalTime depatureTime) {
		this.depatureTime = depatureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}
