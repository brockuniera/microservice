/**
 * 
 */
package com.ss.utopia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	public List<Airports> getspecificAirport(String airportIdentifier) {
		// TODO Auto-generated method stub
		List<String> tempList = new ArrayList<String>();
		tempList.add(airportIdentifier);
		return airportDAO.findAllById(tempList);
	}
}
