package com.example.demo.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.enums.Fuel;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="factorie_id")
	private Factorie factorie;
	
	private String model;
	
	private Integer year;
	
	@Enumerated(EnumType.STRING)
	private Fuel fuel;
	
	private Integer doors;
	
	private BigDecimal cost;
	
	private String color;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Factorie getFactorie() {
		return factorie;
	}

	public void setFactorie(Factorie factorie) {
		this.factorie = factorie;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

	public Integer getDoors() {
		return doors;
	}

	public void setDoors(Integer doors) {
		this.doors = doors;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
