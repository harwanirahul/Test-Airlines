package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FlightServiceTest {

	@Autowired
	FlightService flightService;
	
	@Test
	public void testSearchFlight() {
		String source = "chennai";
		String destination = "mumbai";
		Date date = Date.valueOf("2021-03-06");
		assertNotNull(flightService.searchFlight(source, destination, date));
	}
}
