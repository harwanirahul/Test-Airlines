package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Flight;
//import com.myapp.spring.tdd.model.Flight;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class FlightRepositoryTest {

	@Autowired
	private FlightRepository repository;

	private static File DATA_JSON = Paths.get("resources", "flights.json").toFile();

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {

		Flight flights[] = new ObjectMapper().readValue(DATA_JSON, Flight[].class);
		Arrays.stream(flights).forEach(repository::save);

	}

	@AfterEach
	void tearDown() {
		repository.deleteAll();
	}

	@Test
	@DisplayName("Test Flight not found for non existing id")
	public void testFlightNotFoundForNonExistingId() {

		Flight retrievedFlight = repository.findBySourceAndDestinationAndDate("Pune", "Delhi",
				Date.valueOf("2021-04-07"));

		assertEquals(6, retrievedFlight.getId());

	}

}
