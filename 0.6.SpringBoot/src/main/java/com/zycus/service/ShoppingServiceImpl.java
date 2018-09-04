package com.zycus.service;

import java.sql.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zycus.dto.OrderDTO;
import com.zycus.entity.Customer;
import com.zycus.entity.LineItem;
import com.zycus.entity.Order;
import com.zycus.entity.Product;
import com.zycus.repository.CustomerRepository;
import com.zycus.repository.OrderRepository;
import com.zycus.repository.ProductRepository;

@Service
@Transactional
public class ShoppingServiceImpl implements ShoppingService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@CacheEvict(value="customers.cache", allEntries = true)
	public void newCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	@Cacheable(value = "customers.cache")
	public Iterable<Customer> getListOfRegisteredCustomers(){
		return customerRepository.findAll();
	}
	
	@CacheEvict(value="products.cache", allEntries = true)
	public void newProduct(Product product) {
		productRepository.save(product);
	}
	
	@Cacheable(value="products.cache")
	public Iterable<Product> getListOfProduct() {
		return productRepository.findAll();
	}
	
	public void placeOrder(OrderDTO orderDto) {
		int customerId = orderDto.getCustomerId();
		Map<Integer, Integer> cart = orderDto.getCart();
		
		Customer customer = customerRepository.findById(customerId).get();
		
		Order order = new Order();
		order.setCustomer(customer);
		order.setDate(new Date(System.currentTimeMillis()));
		
		Set<LineItem> lineItems = new HashSet<LineItem>();
		for(Map.Entry<Integer, Integer> entry : cart.entrySet()) {
			int productId = entry.getKey();
			int quantity = entry.getValue();
			
			Product product = productRepository.findById(productId).get();
			int tempquantity = product.getQuantity() - quantity;
			if(product.getQuantity() > 0) {
				if(tempquantity > 0) {
					product.setQuantity(tempquantity);
					productRepository.save(product);
				}else {
					System.out.println("Error");
				}
			}
			
			LineItem lineItem = new LineItem();
			lineItem.setOrder(order);
			lineItem.setProduct(product);
			lineItem.setQuantity(quantity);
			lineItems.add(lineItem);
		}
		
		order.setLineItems(lineItems);
		orderRepository.save(order);
	}
	
	
	
}
