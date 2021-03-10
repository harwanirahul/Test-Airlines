package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo.entity.Flight;
import com.example.demo.service.FlightService;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class FlightControllerTest1 {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private FlightService flightService;
	
	@Test
	public void testGetFlights() throws Exception{
		
		List<Flight> flights = new ArrayList<>();
		
		Flight flight1 =new Flight();
		flight1.setSource("chennai");
		flight1.setDestination("mumbai");
		flight1.setDate(Date.valueOf("2021-03-06"));
		
		flights.add(flight1);
		
		Mockito.when(flightService.getFlights()).thenReturn(flights);
		mockMvc.perform(get("/flights")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1))).andExpect(jsonPath("$[0].source",Matchers.equalTo("chennai")));
		
		
	}
	

}
