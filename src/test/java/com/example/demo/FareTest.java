package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.Fare;
import com.example.demo.service.FareService;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest
public class FareTest {

	List<Fare> fare = new ArrayList<>();

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	public FareService fareService;

	@Test
	public void testGetFare() throws Exception {
//		Flight flight = new Flight();
//		flight.setId(1);

//		Fare fare = new Fare();
//		fare.getFlight().setId(1);

		Mockito.when(fareService.getFareByFlightId(1)).thenReturn((Fare) fare);
		mockMvc.perform(get("/fare-by-flight-id")).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(1))).andExpect(jsonPath("$[0].id", Matchers.equalTo(1)));

	}

}
