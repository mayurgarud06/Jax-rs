package com.fois.dao;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fis.entity.Flight;

public class InMemoryFlightDao {

	private static List<Flight> listOfFlights;
	static {
		listOfFlights = new ArrayList<>();
		listOfFlights.add(new Flight(101, "Air India", "mumbai", "Pune", LocalTime.of(11, 30), LocalTime.of(13, 45)));
		listOfFlights
				.add(new Flight(102, "Spicejet", "Delhi", "Bangalore", LocalTime.of(10, 30), LocalTime.of(12, 45)));
		listOfFlights
				.add(new Flight(103, "Air India", "mumbai", "chennai", LocalTime.of(11, 30), LocalTime.of(19, 45)));
		listOfFlights.add(new Flight(104, "Indigo", "mumbai", "Delhi", LocalTime.of(12, 30), LocalTime.of(23, 45)));
		listOfFlights.add(new Flight(105, "Air India", "Delhi", "Pune", LocalTime.of(5, 30), LocalTime.of(14, 45)));
		listOfFlights.add(new Flight(106, "Spicejet", "Bangalore", "Pune", LocalTime.of(10, 30), LocalTime.of(12, 45)));
		listOfFlights.add(new Flight(107, "Air India", "mumbai", "Pune", LocalTime.of(1, 30), LocalTime.of(11, 45)));
		listOfFlights.add(new Flight(108, "Indigo", "mumbai", "Delhi", LocalTime.of(10, 30), LocalTime.of(19, 45)));
		listOfFlights.add(new Flight(109, "Spicejet", "Delhi", "Pune", LocalTime.of(12, 30), LocalTime.of(21, 45)));
		listOfFlights.add(new Flight(110, "Air India", "Chennai", "mumbai", LocalTime.of(5, 30), LocalTime.of(22, 45)));
		listOfFlights.add(new Flight(111, "Indigo", "chennai", "Pune", LocalTime.of(3, 30), LocalTime.of(11, 45)));
		listOfFlights.add(new Flight(112, "Vistara", "mumbai", "Delhi", LocalTime.of(9, 30), LocalTime.of(12, 45)));
	}

	public void add(Flight flight) {

		listOfFlights.add(flight);
	}

	public List<Flight> getAllFlights() {

		return listOfFlights;
	}

	public List<Flight> getAvaliableFlights(String from, String to) {
		// TODO Auto-generated stub

//		  List <Flight> gfl= new ArrayList<>(); for(Flight i:listOfFlights) {
//		  
//		  if(i.getSource().equals(from) && i.getDestination().equals(to)) { gfl.add(i);
//		  } }
//		  
//		  return gfl;

		return listOfFlights.stream()
				.filter(flight -> flight.getSource().equals(from) && flight.getDestination().equals(to))
				.collect(Collectors.toList());
	}

	public Flight getFlight(int flightNo) {
		// TODO Auto-generated method stub

		for (Flight fl : listOfFlights) {

			if (fl.getFlightNo() == flightNo)
				return fl;
		}
		return null;

	}

}
