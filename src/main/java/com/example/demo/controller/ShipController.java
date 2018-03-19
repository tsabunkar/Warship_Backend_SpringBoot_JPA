package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Ship;
import com.example.demo.service.ShipService;


@RestController
@RequestMapping("/warship/webapi/")
public class ShipController {

	
    
	
	@Autowired
	private ShipService shipService;
	

//		http://localhost:8082/warship/webapi/test
	@RequestMapping(path="/test")
	public String test() {
		System.out.println(shipService.findByShipidcustomize());
		return "working";
	}
	
	
	@RequestMapping(path= "/shiplist", method = RequestMethod.GET)
	public List<Ship> getAll() {
		return shipService.getAllships();
	}

	@RequestMapping(path = "/shiplist/{shipid}", method = RequestMethod.GET)
	public Optional<Ship> getPar(@PathVariable int shipid) {
		return shipService.getParticularShip(shipid);
	}

	@RequestMapping(path = "/shiplist", method = RequestMethod.POST)
	public Ship createShip(@Valid @RequestBody Ship ship) {
		return shipService.createShip(ship);
	}

	@RequestMapping(path = "/shiplist/{shipid}", method = RequestMethod.DELETE)
	public int deleteShip(@PathVariable int shipid) {
		return shipService.removeShip(shipid);
	}

	@RequestMapping(path = "/shiplist/{shipid}", method = RequestMethod.PUT)
	public String updateExistingShip(@Valid @RequestBody Ship ship) {
		return shipService.updateShip(ship);
	}
	
	
}
