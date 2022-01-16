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

import com.example.demo.models.Factory;
import com.example.demo.repositories.FactoryRepository;

@RestController
@RequestMapping(value="/api/factories")
public class FactoryController {

	@Autowired
	FactoryRepository factoryRepository;
	
	@GetMapping("/")
	public List<Factory> listFactories() {
		return factoryRepository.findAll();
	}
	
	@PostMapping("/")
	public Factory saveFactory(@RequestBody Factory factory) {
		return factoryRepository.save(factory);
	}
	
	@DeleteMapping("/{id}")
	public void deleteFactory(@PathVariable(value="id") long id) {
		factoryRepository.deleteById(id);
	}
	
	@PutMapping("/")
	public Factory updateFactory(@RequestBody Factory factory) {
		return factoryRepository.save(factory);
	}
}
