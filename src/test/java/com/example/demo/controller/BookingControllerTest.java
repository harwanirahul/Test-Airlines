package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.common.Common.Gender;
import com.example.demo.common.Common.PreferredClass;
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

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();
	}

	@Test
	public void testBookTicket() throws Exception {

		BookingController bookingcontroller = new BookingController();

		BookingDto bookingDto = new BookingDto();

		bookingDto.setPassenger(getPassenger());
		bookingDto.setDestination("Pune");
		bookingDto.setPreferredClass(PreferredClass.BUSINESSCLASS);
		bookingDto.setDate(Date.valueOf("2021-04-10"));
		bookingDto.setSource("Delhi");

		when(bookingcontroller.bookTicket(bookingDto)).thenReturn(getBookingdetails());

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/bookTicket")
				.contentType(MediaType.APPLICATION_JSON);

//		MockMvc result = mockMvc;
//		result.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].source", Matchers.equalTo("Delhi")));
	}

	private Map<String, Object> getBookingdetails() {
		Map<String, Object> map = new HashMap<>();
		map.put("passenger", getPassenger());
		map.put("source", "Delhi");
		map.put("destination", "Pune");
		map.put("date", Date.valueOf("2021-04-10"));
		map.put("preferredClass", PreferredClass.BUSINESSCLASS);
		return map;
	}

	private Passenger getPassenger() {
		Passenger passenger = new Passenger();
		passenger.setName("vasavi");
		passenger.setAge(23);
		passenger.setContact(12345678);
		passenger.setGender(Gender.FEMALE);
		return passenger;
	}

}
