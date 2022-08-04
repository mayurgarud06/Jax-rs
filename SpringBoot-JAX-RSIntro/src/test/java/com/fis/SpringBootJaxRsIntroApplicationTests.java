package com.fis;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fis.entity.Customer;
import com.fis.repository.CustomerRepository;

@SpringBootTest
class SpringBootJaxRsIntroApplicationTests {
    @Autowired
    private CustomerRepository customerRepository;
    
	@Test
	void add() {
		Customer customer= new Customer();
		customer.setName("mayur");
		customer.setMobileNo(1244589);
		customer.setEmail("mayur@gmail.com");
		customer.setPassword("Mayur123");
		
		customerRepository.save(customer);
	}

	@Test
	void checkIfCustomerExits() {
		int id=customerRepository.findIfCustomerExists("mayur@gmail.com");
		System.out.println(id);
	}
	@Test
	void checkIfIdExits() {
		Customer cut = customerRepository.findById(10);
		System.out.println(cut.getId());
	}
	
	
	
}
