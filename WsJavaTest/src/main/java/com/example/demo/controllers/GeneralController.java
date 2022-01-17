package com.example.demo.controllers;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.enums.Fuel;
import com.example.demo.models.Car;
import com.example.demo.models.Factory;
import com.example.demo.repositories.CarRepository;
import com.example.demo.repositories.FactoryRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@RestController
@RequestMapping(value="/api")
public class GeneralController {

	@Autowired
	CarRepository carRepository;
	
	@Autowired
	FactoryRepository factoryRepository;
	
	@PostMapping("/csv")
	public List<Car> saveCSV(@RequestParam("file") MultipartFile file) throws Exception {
		InputStreamReader inputStreamReader = new InputStreamReader(file.getInputStream());
		CSVReader csvReader = new CSVReaderBuilder(inputStreamReader).withSkipLines(1).build();
		
		List<String[]> rows = csvReader.readAll();
				
		List<Car> cars = new ArrayList<Car>();
		List<Factory> factories = new ArrayList<Factory>();
		
		for(String[] row:rows) {
			Car car = new Car();
			
			car.setId(Integer.parseInt(row[0]));
			
			Factory factory = new Factory();
			factory.setId(Integer.parseInt(row[1]));
			factory.setName(row[2]);
			
			factories.add(factory);
			
			car.setFactorie(factory);
			
			car.setModel(row[3]);
			car.setYear(Integer.parseInt(row[4]));
			car.setFuel(Fuel.valueOf(row[5]));
			car.setDoors(Integer.parseInt(row[6]));
			car.setCost(new BigDecimal(row[7].replaceAll("\\.", "")));
			car.setColor(row[8]);
			
			cars.add(car);
		}
		
		factoryRepository.saveAll(factories);
		carRepository.saveAll(cars);
		
		return cars;
	}
}
