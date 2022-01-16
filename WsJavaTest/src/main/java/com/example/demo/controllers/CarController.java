package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;

@RestController
@RequestMapping(value="/api/cars")
public class CarController {

	@Autowired
	CarRepository carRepository;
	
	@GetMapping("/")
	public List<Car> listFactories() {
		return carRepository.findAll();
	}
	
	@PostMapping("/")
	public Car saveCar(@RequestBody Car car) {
		return carRepository.save(car);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCar(@PathVariable(value="id") long id) {
		carRepository.deleteById(id);
	}
	
	@PutMapping("/")
	public Car updateCar(@RequestBody Car car) {
		return carRepository.save(car);
	}
}
