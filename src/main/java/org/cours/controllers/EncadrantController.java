package org.cours.controllers;


import java.util.Optional;

import org.cours.model.Encadrant;
import org.cours.repos.EncadrantRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EncadrantController {

	@Autowired
	EncadrantRepos encadrantRepos;
	
	
	@GetMapping(value = "/Encadrants")
	public Iterable<Encadrant> getEncadrants(){
		return encadrantRepos.findAll();
	}
	
	
	@GetMapping(value = "/Encadrants/{id}")
	public Optional<Encadrant> findEncadrant(@PathVariable long id) {
		return encadrantRepos.findById(id);
	}
	
	
	@PostMapping(value = "/Encadrants")
	public void saveEncadrant(@RequestBody Encadrant encadrant){
		encadrantRepos.save(encadrant);
	}
	
	
	@DeleteMapping(value = "/Encadrants/{id}")
	public void deleteEncadrant(@PathVariable long id) {
		encadrantRepos.deleteById(id);
	}
	
	@PatchMapping(value = "/Encadrants/{id}")
	public void updateEncadrant(@RequestBody Encadrant encadrant, @PathVariable long id) {
		encadrantRepos.save(encadrant);
	}
	
	
//	@DeleteMapping(value = "/")
//	public void deleteAll() {
//		encadrantRepos.deleteAll();
//	}
}	
