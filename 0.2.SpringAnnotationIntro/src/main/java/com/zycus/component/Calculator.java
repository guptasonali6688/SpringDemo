package com.zycus.component;

import org.springframework.stereotype.Component;

@Component("cal")
public class Calculator {

	public int add() {
		int a = 2, b = 3;
		return a+b;
	}
}
