package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Fare;

@Transactional
public interface FareRepository extends JpaRepository<Fare, Integer> {

	public Fare findByFlightId(int flight_id);

}
