package com.zycus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zycus.dao.CRUDRepository;
import com.zycus.entity.Flight;

//@Component
@Service //alernate for Service
public class FlightService {
	
	@Autowired
	private CRUDRepository crudRepository;
	
	public void addNewFlight(Flight flight) {
		System.out.println(flight);
		crudRepository.add(flight);
	}
	
	public List<Flight> fetchAll() {
		return crudRepository.fetchAll(Flight.class);
	}
}
