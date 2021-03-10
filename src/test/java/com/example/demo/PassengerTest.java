package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Passenger;
import com.example.demo.service.PassengerService;

@SpringBootTest
public class PassengerTest {

	@Autowired
	PassengerService passengerService;
	Passenger passenger;

	public Boolean check_Passenger_By_Id(int id) {
		if (passengerService.getPassengerById(id) != null) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean check_Passengers() {
		if (passengerService.getCustomers() != null) {
			return true;
		} else {
			return false;
		}
	}

	@Test
	public void get_Passenger_By_Id() {
		assertFalse(check_Passenger_By_Id(1));
		assertFalse(check_Passenger_By_Id(4));
	}

	public void get_Passengers() {
		assertFalse(check_Passengers());
		assertFalse(check_Passengers());
	}

}
