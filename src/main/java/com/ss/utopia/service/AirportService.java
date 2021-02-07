/**
 * 
 */
package com.ss.utopia.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.model.Airports;

/**
 * @author jordandivina
 *
 */

@Service
public class AirportService {
	
	@Autowired
	private AirportDAO airportDAO;

	public List<Airports> getAllAirports() {
		return airportDAO.findAll();
	}

	public List<Airports> getSpecificAirport(String airportIdentifier) {
		List<String> tempList = new ArrayList<String>();
		tempList.add(airportIdentifier);
		return airportDAO.findAllById(tempList);
	}

	public String addAirport(Airports newAirport) {
		try {
			airportDAO.save(newAirport);
			return "Success in adding" + newAirport.toString();
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not add " + newAirport.toString());
		}
	}

	public String updateAirport(Airports newAirport) {
		try {
			airportDAO.save(newAirport);
			return "Updated " + newAirport.toString();
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not update " + newAirport.toString());
		}
	}

	public String deleteAirport(Airports newAirport) {
		try {
			airportDAO.delete(newAirport);
			return "Deleted " + newAirport.toString();
		}
		catch(DataIntegrityViolationException e){
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Current airport is still in use. Please try again later " + newAirport.toString());
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not delete " + newAirport.toString());
		}
	}
}
