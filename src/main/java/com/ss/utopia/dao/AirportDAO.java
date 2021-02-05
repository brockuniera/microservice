/**
 * 
 */
package com.ss.utopia.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ss.utopia.model.Airports;

/**
 * @author jordandivina
 *
 */

@Repository
public interface AirportDAO extends JpaRepository<Airports, String>{

}
