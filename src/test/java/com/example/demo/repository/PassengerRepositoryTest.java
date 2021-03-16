package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.AirlinesApplicationTests;
import com.example.demo.entity.Passenger;

public class PassengerRepositoryTest extends AirlinesApplicationTests {

	@Autowired
	private PassengerRepository passengerRepository;

	@Test
	@DisplayName("Passenger not found for given name")
	public void testPassengerForNonExistingName() {
		Passenger getPassenger = passengerRepository.findTopByName("roy");
		assertNull(getPassenger);
	}

}
