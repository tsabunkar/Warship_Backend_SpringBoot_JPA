package com.example.demo.repositry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.dto.Ship;

//This below code is not in use
	//Just an example to show , how to write the native query in 
	//spring boot JPA
public interface ShipRepoCustome  extends JpaRepository<Ship, Integer>{

	
	@Query(value = "SELECT shipid FROM ship_table ORDER BY shipid DESC LIMIT 1 ", nativeQuery = true)
	  int findByShipidcustomize();
	
	
	
}
