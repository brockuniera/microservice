/**
 * 
 */
package com.ss.utopia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.ss.utopia.model.Airports;
import com.ss.utopia.service.AirportService;

/**
 * @author jordandivina
 *
 */

@RestController
@RequestMapping("/utopia/airports")
public class AirportController {
	
	@Autowired
	private AirportService airportService;
	
	@GetMapping(path = {"/", "", "/list"})
	@ResponseStatus(HttpStatus.OK)
	public List<Airports> getAllAirports(){
		return airportService.getAllAirports();
	}
	
	@GetMapping(path = {"/{AirportID}"})
	@ResponseStatus(HttpStatus.OK)
	public List<Airports> getspecificAirport(@PathVariable("AirportID") String airportId){
		return airportService.getspecificAirport(airportId);
	}
}
