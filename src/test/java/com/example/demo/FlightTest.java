package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.common.Common.PreferredClass;
import com.example.demo.entity.Flight;
import com.example.demo.service.FlightService;
import com.sun.el.parser.ParseException;

@SpringBootTest
public class FlightTest {

	@Autowired
	FlightService flightService;
	Flight flight;

	public boolean SearchTest(String destination, String source, Date date) {

		if (flightService.getFlightBySourceAndDestinationAndDate(source, destination, date) != null) {
			return true;
		} else {
			return false;
		}

	}

	public boolean CheckSeat(PreferredClass preferredClass, int id) {
		Flight fid = flightService.getFlightById(id);
		if (fid != null) {

			if (preferredClass.equals(PreferredClass.BUSINESSCLASS)) {
				if (fid.getAvailableBusinessClassSeats() > 0) {
					return true;
				} else {
					return false;
				}
			} else {
				if (fid.getAvailableEconomyClassSeats() > 0) {
					return true;

				} else {
					return false;
				}
			}

		} else {
			return false;
		}

	}

	@Test
	public void searchTest() throws ParseException, java.text.ParseException {
		String datetmp = "2021-04-01";
		String datetmp1 = "23-03-2021";
		Date d1 = Date.valueOf(datetmp);
		assertTrue(SearchTest("Chennai", "Pune", d1));
		assertFalse(SearchTest("Hyderabad", "Pune", d1));
	}

	@Test
	public void checkSeat() {
		assertTrue(CheckSeat(PreferredClass.BUSINESSCLASS, 1));
		assertFalse(CheckSeat(PreferredClass.ECONOMYCLASS, 3));
		assertTrue(CheckSeat(PreferredClass.ECONOMYCLASS, 1));
		assertFalse(CheckSeat(PreferredClass.BUSINESSCLASS, 3));

	}

}
