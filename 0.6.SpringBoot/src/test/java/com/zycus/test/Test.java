package com.zycus.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.zycus.controller.ShoppingController;
import com.zycus.entity.Customer;
import com.zycus.entity.Product;
import com.zycus.service.ShoppingServiceImpl;

public class Test {

	@org.junit.Test
	public void testAddCustomer() {
		Customer customer = new Customer();
		customer.setName("Sonali");
		customer.setEmail("gs@gmail.com");
		
		//for accessing REST services
		String url = "http://localhost:8080/shopping/addCustomer";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(url,customer , String.class);
		System.out.println(response.getBody());
	}
	
	@org.junit.Test
	public void testAddProduct() {
		Product product = new Product();
		product.setName("XYS");
		product.setQuantity(100);
		product.setPrice(1000);
		
		//for accessing REST services
		String url = "http://localhost:8080/shopping/addProduct";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(url,product , String.class);
		System.out.println(response.getBody());
	}
	
	@org.junit.Test
	public void testProductList() {
		//for accessing REST services
		String url = "http://localhost:8080/shopping/productList";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		System.out.println(response.getBody());
	}
	
	@org.junit.Test
	public void testCustomerList() {
		//for accessing REST services
		String url = "http://localhost:8080/shopping/customerList";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		System.out.println(response.getBody());
	}
	

}
