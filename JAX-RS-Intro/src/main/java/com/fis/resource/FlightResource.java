package com.fis.resource;

import java.util.List;

import javax.ws.rs.*;

import com.fis.entity.Flight;
import com.fois.dao.InMemoryFlightDao;

@Path("/flight")
public class FlightResource {
	// http://localhost:8080/JAX-RS-Intro/api/flight/search?from=mumbai&to=Delhi
	private InMemoryFlightDao dao = new InMemoryFlightDao();
	@GET
	@Path("/search")
	public List<Flight> getFlights(@QueryParam("from") String from, @QueryParam("to") String to) {
		
		List<Flight> list = dao.getAvaliableFlights(from, to);
		return list;

	}

	@GET
	@Path("/search/v2/{from}/{to}")
	public List<Flight> getFlightsV2(@PathParam("from") String from, @PathParam("to") String to) {
		
		List<Flight> list = dao.getAvaliableFlights(from, to);
		return list;

	}

	// http://localhost:8080/JAX-RS-Intro/api/flight/102
	@GET
	@Path("/{flightNo}")
	public Flight getFlight(@PathParam("flightNo") int flightNo) {
		
		Flight flight = dao.getFlight(flightNo);
		return flight;

	}
	@GET
	@Path("/all")
	public List<Flight> getAll(){
		
		return dao.getAllFlights();
	}

	@POST
	@Path("/add")
	public String add(Flight flight) {
		dao.add(flight);
		return "Flight sucesscully added";
	}

}
