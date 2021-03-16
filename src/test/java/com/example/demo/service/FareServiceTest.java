package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Fare;
import com.example.demo.repository.FareRepository;
import com.example.demo.service.impl.FareServiceImpl;

@SpringBootTest
public class FareServiceTest {

	@InjectMocks
	private FareServiceImpl service;

	@Mock
	private FareRepository repository;

	@Test
	@DisplayName("get fare by flight Id")
	public void testFareService() {
		when(repository.findByFlightId(1)).thenReturn(mock(Fare.class));
		Fare fare = service.getFareByFlightId(1);
		assertNotNull(fare);
	}

}