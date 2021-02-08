/**
 * 
 */
package com.ss.utopia.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.model.Flights;


@Service
public class FlightService {
	
	@Autowired
	private FlightDAO dao;

	public List<Flights> getAllFlights() {
		return dao.findAll();
	}
	
	public Optional<Flights> getSpecificFlight(String Number){
		return Optional.ofNullable(dao.getFlightWithNumber(Number.toUpperCase())); // .toUpperCase() used to add case-insensitivity
	}
	
	public List<Flights> getAllFlightsDepartingFromAirport(String airportid){
		return dao.getAllFlightsDepartingFromAirport(airportid.toUpperCase());
	}
	
	public List<Flights> getAllFlightsArrivingToAirport(String airportid){
		return dao.getAllFlightsArrivingToAirport(airportid.toUpperCase());
	}

	public List<Flights> getAllFlightsBetweenAirports(String airportid1, String airportid2){
		return dao.getAllFlightsBetweenAirports(airportid1.toUpperCase(), airportid2.toUpperCase());
	}
}
