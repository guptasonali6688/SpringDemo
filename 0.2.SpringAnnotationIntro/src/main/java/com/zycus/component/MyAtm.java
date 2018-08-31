package com.zycus.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("atm")
public class MyAtm implements ATM {


	private Bank bank;

	@Autowired
	@Qualifier("b")
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public void withDraw(int accNo, double amount) {
		System.out.println("WithDrawing...");
		bank.communicate(null);		
	}
}
