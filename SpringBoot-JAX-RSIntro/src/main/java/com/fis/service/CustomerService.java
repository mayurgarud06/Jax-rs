package com.fis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.entity.Customer;
import com.fis.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/*
	 * public void register(Customer customer) { try { int
	 * id=customerRepository.findIfCustomerExists(customer.getEmail()); //throw an
	 * exception to report Customer registration is failed } catch(Exception e){
	 * customerRepository.save(customer); } }
	 */
	public void register2(Customer customer) {

		long count = customerRepository.findIfCustomerExists2(customer.getEmail());
		if (count == 0)
			customerRepository.save(customer);
		else
			throw new CustomerServiceException("customer already exits");

	}
	
	public Customer login(String email,String password ) {
			Customer customer = customerRepository.findByEmailAndPassword(email,password);
		    if (customer!=null)
			  return customer;
		    else
		    	throw new CustomerServiceException("Invalid email/password");
	}

	public Customer getCustById(int id) {
		// TODO Auto-generated method stub
		//Customer customer = customerRepository.findById(id).get();
	  Customer customer = customerRepository.findById(id);
	    if (customer!=null)
		  return customer;
	    else
	    	throw new CustomerServiceException("Invalid Id");
		 
	}
	
	public void update(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void delete(int id) {
		customerRepository.deleteById(id);
	}
	
}
