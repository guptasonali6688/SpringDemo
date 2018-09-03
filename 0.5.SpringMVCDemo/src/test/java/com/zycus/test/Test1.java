package com.zycus.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zycus.entity.Flight;
import com.zycus.service.FlightService;

public class Test1 {

	@Test
	public void testAddFlight() {
		ApplicationContext context = new ClassPathXmlApplicationContext("mvc-servlet.xml");
		
		FlightService flightService = (FlightService) context.getBean("flightService");
		//FlightService flightService = new FlightService();
		Flight flight = new Flight();
		flight.setFlightNo("1");
		flight.setCarrier("XYZ");
		flight.setSource("Mumbai");
		flight.setDestination("Delhi");
		flight.setDuration(2);
		flightService.addNewFlight(flight);
	}

}
