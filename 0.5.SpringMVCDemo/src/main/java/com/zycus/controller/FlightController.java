package com.zycus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zycus.entity.Flight;
import com.zycus.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	private FlightService flightservice;
	
	@RequestMapping(value="/flight/all", method = RequestMethod.GET, produces="application/json")
	public List<Flight> getAll() {
		return flightservice.fetchAll();
	}
	
	@RequestMapping(value="/flight/add",
					method = RequestMethod.POST,
					consumes = "application/json",
					produces = "text/plain")
	public String add(@RequestBody Flight flight) {
		flightservice.addNewFlight(flight);
		return "Flight record created successfully";
	}
}
