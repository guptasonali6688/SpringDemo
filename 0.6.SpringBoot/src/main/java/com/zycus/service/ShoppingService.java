package com.zycus.service;

import com.zycus.dto.OrderDTO;
import com.zycus.entity.Customer;
import com.zycus.entity.Product;

public interface ShoppingService {

	void newCustomer(Customer customer);

	void newProduct(Product product);

	void placeOrder(OrderDTO orderDto);

	Iterable<Customer> getListOfRegisteredCustomers();
	
	Iterable<Product> getListOfProduct();
}