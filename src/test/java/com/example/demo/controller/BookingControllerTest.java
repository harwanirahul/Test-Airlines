package com.example.demo.controller;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.dto.BookingDto;
import com.example.demo.entity.Passenger;
//import com.example.demo.entity.Passenger.Gender;
import com.example.demo.service.BookingService;
import com.example.demo.service.FareService;
import com.example.demo.service.FlightService;
import com.example.demo.service.PassengerService;

@ExtendWith(MockitoExtension.class)
public class BookingControllerTest {
	
	@Mock
	private FlightService flightService;
	
	@Mock
	private PassengerService passengerService;
	
	@Mock
	private FareService fareService;
	
	@Mock
	private BookingService bookingService;
	
	@InjectMocks
	private BookingController bookingController;
	
	BookingDto bookingDto=new BookingDto();

	
	@Test
	public void testBookTicket() throws Exception{
		
		when(bookingController.bookTicket(bookingDto)).thenReturn(getBookingdetails());
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/bookticket");
		
		
	}

	enum Gender {
		male, female, other
	};

	private Map<String, Object> getBookingdetails() {
		Map<String, Object> map = new HashMap<>();
		map.put("passenger",getPassenger());
		//map.put("source", )
		
		
		
		return null;
	}


	private Object getPassenger() {
		Passenger passenger=new Passenger();
		passenger.setName("vasavi");
		passenger.setAge(23);
		passenger.setContact(12345678);
		//passenger.setGender(female);
		return passenger;
	}
	

	
}
