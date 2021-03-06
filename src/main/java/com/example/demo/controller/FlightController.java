package com.example.demo.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FlightDto;
import com.example.demo.entity.Flight;
import com.example.demo.service.FlightService;

@RestController
public class FlightController {
	@Autowired
	FlightService flightService;

	@GetMapping("/flight")
	public List<Flight> getFlights() {
		return flightService.getFlights();
	}

	@PostMapping("/searchFlight")
	public List<Flight> getRespectiveFlights(@RequestBody FlightDto flightdto) {
		List list = new ArrayList();
		String source = flightdto.getSource();
		String destination = flightdto.getDestination();
		Date date = flightdto.getDate();
		// PreferredClass preferredClass = flightdto.getPreferredClass();
		// Flight flight = flightService.searchFlight(source, destination, date);
		if (flightService.getFlightBySourceAndDestinationAndDate(source, destination, date) == null) {
			list.add("Error! No flights found");
			return list;
		}
//		else if (!flightService.checkSeatAvailability(flight, preferredClass)) {
//			list.add("Error! Seats not available");
//			return list;
//		} 
		else {
			Flight details = flightService.getFlightBySourceAndDestinationAndDate(source, destination, date);
			list.add(details);
			return list;
		}

	}
//
//	@PostMapping("/checkSeat")
//	public Boolean checkSeatAvailiability(@RequestBody FlightDto flightdto) {
//
//		String source = flightdto.getSource();
//		String destination = flightdto.getDestination();
//		Date date = flightdto.getDate();
//		PreferredClass preferredClass = flightdto.getPreferredClass();
//
//		Flight flight = flightService.searchFlight(source, destination, date);
//		return flightService.checkSeatAvailability(flight, preferredClass);
//	}

}
