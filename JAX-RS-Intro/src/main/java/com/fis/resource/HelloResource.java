package com.fis.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloResource {
	
	@GET
	public String hello(){
		return "Hello everyone this tutorial of JAX_RS1";
		
	}
	

}
