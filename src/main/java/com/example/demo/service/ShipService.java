package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Ship;
import com.example.demo.repositry.ShipRepo;
import com.example.demo.repositry.ShipRepoCustome;


@Service
public class ShipService {
	@Autowired
	private ShipRepo shipRepo;
	
	/*@Autowired
	private ShipRepoCustome shipRepoCustom;*/

	public List<Ship> getAllships() {
		List<Ship> listOfships = new ArrayList<Ship>();
		
		shipRepo.findAll().forEach(listOfships::add);
		return listOfships;

	}
	

	public Optional<Ship> getParticularShip(int id) {
		return shipRepo.findById(id);
	}

	public Ship createShip(Ship ship) {
		return shipRepo.save(ship);
	}
	
	//for using the customize logic method ie-deleteByShipid()
	//must use the @Transactional annotation.
	@Transactional
	public int removeShip(int id) {
	return 	shipRepo.deleteByShipid(id);
	}

	public String updateShip(Ship ship) {
		Ship p = shipRepo.save(ship);
		return p != null ? "1 Record inserted.." : "No record inserted";
	}
	
	
	//This below code is not in use
		//Just an example to show , how to write the native query in 
		//spring boot JPA
	public int findByShipidcustomize() {
		return shipRepo.findByShipidcustomize();
	}
}
