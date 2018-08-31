package com.zycus.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zycus.component.Calculator;
import com.zycus.component.HelloWorld;
import com.zycus.component.MyAtm;
import com.zycus.component.TextEditor;

public class SpringTest {

	@Test
	public void testHelloWorld() {
	
		//Loading IoC Container
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
		
		//Accessing HellWorld
		HelloWorld hw = (HelloWorld) context.getBean("hw"); //id
		System.out.println(hw.sayHello());
		
	}
	
	@Test
	public void testCalculator() {
	
		//Loading IoC Container
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
		
		//Accessing HellWorld
		Calculator cal = (Calculator) context.getBean("cal"); //id
		System.out.println(cal.add());
		
	}
	
	@Test
	public void testTextEditor() {
	
		//Loading IoC Container
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
		
		//Accessing HellWorld
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.load("abc.txt");
		
	}
	
	@Test
	public void testAtmBank() {
	
		//Loading IoC Container
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
		
		//Accessing HellWorld
		MyAtm atm = (MyAtm) context.getBean("atm");
		atm.withDraw(101, 10000);
		
	}

}
