package com.zycus.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zycus.dao.CarPartsDAO;
import com.zycus.dao.impl.CarPartsDAOImpl;
import com.zycus.entity.CarPart;

public class TestCarParts {

	@Test
	public void testAddCarParts() {
		//Loading IoC Container
				ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
				
				//Accessing HellWorld
				CarPartsDAO dao = (CarPartsDAO) context.getBean("carPartsDAOImpl");
				CarPart carPart = new CarPart();
				carPart.setPartNo(1);
				carPart.setName("ABC");
				carPart.setCarModel("YYY");
				carPart.setQuantity(2);
				carPart.setPrice(4894);
				dao.addNewPart(carPart);
		
	}
	
	@Test
	public void testList() {
		//Loading IoC Container
				ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
				
				//Accessing HellWorld
				CarPartsDAO dao = (CarPartsDAO) context.getBean("carPartsDAOImpl");
				List<CarPart> list = dao.getAvailable();
				for(CarPart carpart: list) {
					System.out.println(carpart.getPartNo()+ " " +carpart.getName());
				}
		
	}
	
	@Test
	public void testAddCarParts2() {
		//Loading IoC Container
				ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
				
				//Accessing HellWorld
				CarPartsDAO dao = (CarPartsDAO) context.getBean("carPartsDAOImpl2");
				CarPart carPart = new CarPart();
				carPart.setPartNo(1);
				carPart.setName("ABC");
				carPart.setCarModel("YYY");
				carPart.setQuantity(2);
				carPart.setPrice(4894);
				dao.addNewPart(carPart);
		
	}
	
	@Test
	public void testList2() {
		//Loading IoC Container
				ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
				
				//Accessing HellWorld
				CarPartsDAO dao = (CarPartsDAO) context.getBean("carPartsDAOImpl2");
				List<CarPart> list = dao.getAvailable();
				for(CarPart carpart: list) {
					System.out.println(carpart.getPartNo()+ " " +carpart.getName());
				}
		
	}
	
	@Test
	public void testAddCarParts3() {
		//Loading IoC Container
				ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
				
				//Accessing HellWorld
				CarPartsDAO dao = (CarPartsDAO) context.getBean("carPartsDAOImpl");
				CarPart carPart = new CarPart();
				carPart.setPartNo(1);
				carPart.setName("ABC");
				carPart.setCarModel("YYY");
				carPart.setQuantity(2);
				carPart.setPrice(4894);
				dao.addNewPart(carPart);
		
	}
	
	@Test
	public void testAddCarParts4() {
		//Loading IoC Container
				ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
				
				//Accessing HellWorld
				CarPartsDAO dao = (CarPartsDAO) context.getBean("carPartsDAOImpl4");
				CarPart carPart = new CarPart();
				carPart.setPartNo(1);
				carPart.setName("ABC");
				carPart.setCarModel("YYY");
				carPart.setQuantity(2);
				carPart.setPrice(4894);
				dao.addNewPart(carPart);
		
	}
	
	@Test
	public void testList4() {
		//Loading IoC Container
				ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
				
				//Accessing HellWorld
				CarPartsDAO dao = (CarPartsDAO) context.getBean("carPartsDAOImpl4");
				List<CarPart> list = dao.getAvailable();
				for(CarPart carpart: list) {
					System.out.println(carpart.getPartNo()+ " " +carpart.getName());
				}
		
	}

}
