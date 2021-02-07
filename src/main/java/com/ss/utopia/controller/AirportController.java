/**
 * 
 */
package com.ss.utopia.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
	
	@GetMapping(path = {"/", "", "/list", "/airport"},produces= {"application/json", "application/xml"})
	public ResponseEntity<List<Airports>> getAllAirports(){
		List<Airports> tempList = airportService.getAllAirports();
		if (tempList.size() == 0) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		else {
			return ResponseEntity.ok(tempList);
		}
	}
	
	@GetMapping(path = {"/{AirportID}", "/airport/{AirportID}"},produces= {"application/json", "application/xml"})
	public ResponseEntity<List<Airports>> getspecificAirport(@PathVariable("AirportID") String airportId){
		List<Airports> tempList = airportService.getSpecificAirport(airportId);
		if (tempList.size() == 0) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		else {
			return ResponseEntity.ok(tempList);
		}
	}
	
	@PostMapping(path = {"/airport"}, consumes= {"application/json", "application/xml"}, produces= {"application/json", "application/xml"})
	public ResponseEntity<String> addAirport(@RequestBody Airports newAirport) {
		return ResponseEntity.status(HttpStatus.OK).body(airportService.addAirport(newAirport));
	}
	
	@PutMapping(path = {"/airport"}, consumes= {"application/json", "application/xml"}, produces= {"application/json", "application/xml"})
	public ResponseEntity<String> updateAirport(@RequestBody Airports newAirport) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(airportService.updateAirport(newAirport));
	}
	
	//only works if airport is no longer in use by airline, returns 500 error if that is the case
	@DeleteMapping(path = {"/airport"}, consumes= {"application/json", "application/xml"}, produces= {"application/json", "application/xml"})
	public ResponseEntity<String> deleteAirport(@RequestBody Airports newAirport) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(airportService.deleteAirport(newAirport));
	}
}
