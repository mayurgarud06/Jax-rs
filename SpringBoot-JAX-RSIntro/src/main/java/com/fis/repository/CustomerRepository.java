package com.fis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fis.entity.Customer;

//Repository is another name for Daoas
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("select c.id from Customer c where c.email=?1")
	public int findIfCustomerExists(String email);
	@Query("select count(c.id) from Customer c where c.email=?1")
	public long findIfCustomerExists2(String email);
	//@Query("select count(c.id) from Customer c  where c.email=?1 and c.password=?2 ")
	public Customer findByEmailAndPassword(String email,String password);
	//@Query("select * from Customer c  where c.id=?1")
    public Customer findById(int id); 

}
