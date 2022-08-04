package com.fis.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;


import com.fis.entity.Customer;
import com.fis.model.CustomerInfo;
import com.fis.model.LoginInfo;
import com.fis.service.CustomerService;
import com.fis.service.CustomerServiceException;

@Path("/customer")
public class CustomerResource {
	@Autowired
	private CustomerService customerService;

	@POST
	@Path("/register")
	public String register(Customer customer) {
		try {
		customerService.register2(customer);
		return "customer is register sucessfully";
		}
		catch(CustomerServiceException e) {
			return e.getMessage();
		}
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CustomerInfo login(LoginInfo loginInfo) {
		try {
		Customer customer=customerService.login(loginInfo.getEmail(),loginInfo.getPassword());
		CustomerInfo info= new CustomerInfo();
		info.setStatus(true);
		info.setId(customer.getId());
		info.setName(customer.getName());
		
		return info;
		}
		catch(CustomerServiceException e) {
			//return e.getMessage();
			CustomerInfo info= new CustomerInfo();
			info.setStatus(false);
			info.setErrorIfAny(e.getMessage());
			return info;
		}
		
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomerInfo get(@PathParam("id") int id) {
		try {
	      Customer customer= customerService.getCustById( id);
	      CustomerInfo info= new CustomerInfo();
			info.setStatus(true);
			info.setId(customer.getId());
			info.setName(customer.getName());
	      return info;
		}
		catch(CustomerServiceException e) {
			CustomerInfo info= new CustomerInfo();
			info.setStatus(false);
			info.setErrorIfAny(e.getMessage());
			return info;
			
		}
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(Customer customer) {
		customerService.update(customer);
		return "Customer details updated suceessfully!";
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(@PathParam("id")int id) {
		customerService.delete(id);
		return "Customer deleted sucessfully";
	}
	
	
	
	

}
