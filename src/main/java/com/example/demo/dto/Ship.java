package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

/*import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;*/

/*@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString*/

@Entity
@Table(name = "ship_table")
public class Ship {
	
	@Id
	@GenericGenerator(name="myId", strategy="com.example.demo.dto.CustomizeIdGenerator")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator="myId")
	private int shipid;
	private String shipname;
	private String shipdescription;
	private String shipcondition;
	private double shipprice;
	
	public int getShipid() {
		return shipid;
	}
	public void setShipid(int shipid) {
		this.shipid = shipid;
	}
	public String getShipname() {
		return shipname;
	}
	public void setShipname(String shipname) {
		this.shipname = shipname;
	}
	public String getShipdescription() {
		return shipdescription;
	}
	public void setShipdescription(String shipdescription) {
		this.shipdescription = shipdescription;
	}
	public String getShipcondition() {
		return shipcondition;
	}
	public void setShipcondition(String shipcondition) {
		this.shipcondition = shipcondition;
	}
	public double getShipprice() {
		return shipprice;
	}
	public void setShipprice(double shipprice) {
		this.shipprice = shipprice;
	}
	@Override
	public String toString() {
		return "Ship [shipid=" + shipid + ", shipname=" + shipname + ", shipdescription=" + shipdescription
				+ ", shipcondition=" + shipcondition + ", shipprice=" + shipprice + "]";
	}
	public Ship(int shipid, String shipname, String shipdescription, String shipcondition, double shipprice) {
		super();
		this.shipid = shipid;
		this.shipname = shipname;
		this.shipdescription = shipdescription;
		this.shipcondition = shipcondition;
		this.shipprice = shipprice;
	}
	
	
	public Ship() {
		// TODO Auto-generated constructor stub
	}
	
	
}
