package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FareDto;
import com.example.demo.entity.Fare;
import com.example.demo.entity.Flight;
import com.example.demo.service.FareService;

@RestController
public class FareController {
	@Autowired
	FareService fareService;

	Flight flight;

	@GetMapping("/fare")
	public List<Fare> getFares() {
		return fareService.getFares();
	}

	@PostMapping("/searchFare")
	public Fare searchFare(@RequestBody FareDto fdto) {
		String source = fdto.getSource();
		String destination = fdto.getDestination();
		int flight_id = fdto.getFlightId();

		return fareService.getFareBySourceAndDestinationAndFlight_id(source, destination, flight_id);

	}

}
