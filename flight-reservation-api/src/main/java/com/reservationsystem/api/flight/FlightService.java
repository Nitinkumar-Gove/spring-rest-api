package com.reservationsystem.api.flight;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
	
	@Autowired
	private FlightDataHandler flightDataHandler;
	
	// raw data store
	List<Flight> flights = new ArrayList<>(Arrays.asList(new Flight("1",2000,"Pune","Mumbai",new Date(),new Date(),50,"Daily flight"),
			new Flight("2",2000,"Pune","Bangalore",new Date(),new Date(),50,"Daily flight"),
			new Flight("3",2000,"Pune","Goa",new Date(),new Date(),50,"Daily flight")));	
	
	/**
	 * function to get all the flights available
	 * @return list of flights
	 */	
	public List<Flight> getAllFlights(){ 
		
		// method 1 - Hardcoded
		
		// return flights;
		
		// method 2 - derby + JPA
		
		List<Flight> flights_fromdb = new ArrayList<Flight>();
		
		flightDataHandler.findAll()
		.forEach(flights_fromdb::add);
		
		return flights_fromdb;
	}
	
	/**
	 * function to get the flight with flight ID provided
	 * @param flightID
	 * @return flight
	 */
	public Flight getFlight(String flightID){
		// return flights.stream().filter(f -> f.getNumber().equals(flightID)).findFirst().get();
		
		return flightDataHandler.findOne(flightID);
	}
	
	/**
	 * function to add new flight to the collection
	 * @param flight - new flight to record to be added
	 */
	public void addFlight(Flight flight){
		// method 1 - Hardcoded
		
		// flights.add(flight);
		
		// method 2 - add to derby through jpa
		
		flightDataHandler.save(flight);
		
	}
	
	/**
	 * functiont to update the flight record with the provided flight record
	 * @param id
	 * @param flight
	 */
	public void updateFlight(String id, Flight flight){
		/*
		 * for(int i=0;i<flights.size();i++){
			if(flights.get(i).getNumber().equalsIgnoreCase(id)){
				flights.get(i).setNumber(flight.getNumber());
				flights.get(i).setPrice(flight.getPrice());
				flights.get(i).setArrivalTime(flight.getArrivalTime());
				flights.get(i).setDepartureTime(flight.getDepartureTime());
				flights.get(i).setto_location(flight.getto_location());
				flights.get(i).setfrom_location(flight.getfrom_location());
				flights.get(i).setDescription(flight.getDescription());
				flights.get(i).setSeatsLeft(flight.getSeatsLeft());
				break;				
			}
		}		
		*/
		
		flightDataHandler.save(flight);
		
		
	}	
	
	/**
	 * function to delete a flight
	 * @param id
	 */
	public void deleteFlight(String id){
		/*
		 * int position = -1;
		for(int i=0;i<flights.size();i++){
			if(flights.get(i).getNumber().equalsIgnoreCase(id)){
				position = i;
				break;				
			}
		}		
		
		flights.remove(position);
		*/
		
		flightDataHandler.delete(id);
	}
}
