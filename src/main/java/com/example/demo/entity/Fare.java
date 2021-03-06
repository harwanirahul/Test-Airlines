package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Fare {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "source", nullable = false)
	String source;

	@Column(name = "destination", nullable = false)
	String destination;

	@Column(name = "business_class_fare", nullable = false)
	int businessClassFare;

	@Column(name = "economy_class_fare", nullable = false)
	int economyClassFare;

//	@Column(name = "departure_date", nullable = false)
//	Date departureDate;
	@OneToOne(cascade = { CascadeType.ALL })
	private Flight flight;

	public Fare(int id, String source, String destination, int businessClassFare, int economyClassFare, Flight flight) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.businessClassFare = businessClassFare;
		this.economyClassFare = economyClassFare;
		this.flight = flight;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getId() {
		return id;
	}

//	public Date getDepartureDate() {
//		return departureDate;
//	}
//
//	public void setDepartureDate(Date departureDate) {
//		this.departureDate = departureDate;
//	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestinaton() {
		return destination;
	}

	public void setDestinaton(String destinaton) {
		this.destination = destinaton;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getBusinessClassFare() {
		return businessClassFare;
	}

	public void setBusinessClassFare(int businessClassFare) {
		this.businessClassFare = businessClassFare;
	}

	public int getEconomyClassFare() {
		return economyClassFare;
	}

	public void setEconomyClassFare(int economyClassFare) {
		this.economyClassFare = economyClassFare;
	}

}
