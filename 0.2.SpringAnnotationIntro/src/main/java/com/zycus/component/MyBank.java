package com.zycus.component;

import org.springframework.stereotype.Component;

@Component("b")
public class MyBank implements Bank {

	public void communicate(byte[] data) {
		
		System.out.println("Communicating..");
	}
}
