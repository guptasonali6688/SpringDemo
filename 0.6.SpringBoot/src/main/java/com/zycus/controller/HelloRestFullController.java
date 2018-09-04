package com.zycus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestFullController {

	@RequestMapping(value="/hello" , method = RequestMethod.GET, produces = "text/plain")
	public String hello() {
		return "Welcome to Spring MVC"; //model
	}
}
