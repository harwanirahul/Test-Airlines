package com.example.demo.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.example.demo.common.Common.PreferredClass;
import com.example.demo.entity.Flight;

@Component
public class FareDto {

	private Flight flight;
	private String source;

	private String destination;

	private Date date;

	private PreferredClass preferredClass;

	public int getFlightId() {
		return flight.getId();
	}

	public PreferredClass getPreferredClass() {
		return preferredClass;
	}

	public void setPreferredClass(PreferredClass preferredClass) {
		this.preferredClass = preferredClass;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
