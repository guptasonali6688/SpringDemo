package com.zycus.component;

public class MyAtm implements ATM {


	private Bank bank;
	//setter injection
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public void withDraw(int accNo, double amount) {
		System.out.println("WithDrawing...");
		bank.communicate(null);		
	}
}
