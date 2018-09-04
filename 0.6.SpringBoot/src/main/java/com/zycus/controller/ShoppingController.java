package com.zycus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zycus.dto.OrderDTO;
import com.zycus.entity.Customer;
import com.zycus.entity.Product;
import com.zycus.service.ShoppingService;

@RestController
@RequestMapping("/shopping/*")
public class ShoppingController {
	
	@Autowired
	private ShoppingService service;
	
	@RequestMapping(value="/addCustomer",
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "text/plain")
	public String addCustomer(@RequestBody Customer customer) {
		service.newCustomer(customer);
		return "Customer registered successfully";
	}
	

	@RequestMapping(value="/addProduct",
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "text/plain")
	public String addProduct(@RequestBody Product product) {
		service.newProduct(product);
		return "Product record created successfully";
	}
	

	@RequestMapping(value="/placeOrder", method=RequestMethod.POST, produces="application/json") 
	public String placeOrder(@RequestBody OrderDTO orderDTO) {
		service.placeOrder(orderDTO);
		return "Order placed";
	}
	
	@RequestMapping(value="/customerList" , method = RequestMethod.GET, produces = "application/json")
	public Iterable<Customer> getCustomerList() {
		return service.getListOfRegisteredCustomers();
	}
	
	@RequestMapping(value="/productList" , method = RequestMethod.GET, produces = "application/json")
	public Iterable<Product> getProductList() {
		return service.getListOfProduct();
	}

}
