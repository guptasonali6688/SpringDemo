package com.zycus.component;

import org.springframework.stereotype.Component;

@Component("hw") //<bean id="hw" class="...HelloWorld" >
public class HelloWorld {
	
	public String sayHello() {
		return "Hello ";
	}
}
