package com.example.demo.repositry;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.dto.Ship;

public interface ShipRepo extends CrudRepository<Ship, Integer>{

	public int deleteByShipid(int shipid);
	
		//This below code is not in use
		//Just an example to show , how to write the native query in 
		//spring boot JPA
	@Query(value = "SELECT shipid FROM ship_table ORDER BY shipid DESC LIMIT 1 ", nativeQuery = true)
	  int findByShipidcustomize();
	

	
}
