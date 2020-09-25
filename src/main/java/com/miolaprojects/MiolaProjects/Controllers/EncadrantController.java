package com.miolaprojects.MiolaProjects.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miolaprojects.MiolaProjects.Repos.EncadrantRepository;
import com.miolaprojects.MiolaProjects.models.Encadrant;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EncadrantController {

	@Autowired
	private EncadrantRepository encadrantRepository;
	
	
	@RequestMapping("/encadrants")
	public Iterable<Encadrant> getEncadrants() 
	{
		return encadrantRepository.findAll();
	}
	
	@RequestMapping("/encadrants/{id}")
	public Optional<Encadrant> getEncadrant(@PathVariable Long id) 
	{
		return encadrantRepository.findById(id);
	}
	
	@RequestMapping( method = RequestMethod.POST, value = "/encadrants")
	public void addEncadrant(@RequestBody Encadrant encadrant) 
	{
		encadrantRepository.save(encadrant);
	}
	
	@RequestMapping( method = RequestMethod.PUT, value = "/encadrants/{id}")
	public void modifyEncadrant(@RequestBody Encadrant encadrant,@PathVariable Long id) 
	{
		encadrantRepository.save(encadrant);
	}
	
	@RequestMapping( method = RequestMethod.PATCH, value = "/encadrants/{id}")
	public void editEncadrant(@RequestBody Encadrant encadrant,@PathVariable Long id) 
	{
		encadrantRepository.save(encadrant);
	}
	
	@RequestMapping( method = RequestMethod.DELETE, value = "/encadrants/{id}")
	public void deleteEncadrant(@PathVariable Long id) 
	{
		encadrantRepository.deleteById(id);
	}
}
