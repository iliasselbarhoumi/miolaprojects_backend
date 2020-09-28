package org.cours.controllers;

import java.util.Optional;

import org.cours.model.Etudiant;
import org.cours.repos.EtudiantRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EtudiantController {

	
	@Autowired
	EtudiantRepos etudiantRepos;
	
	
	@GetMapping(value = "/etudiants")
	public Iterable<Etudiant> getAllEtudiants(){
		
		return etudiantRepos.findAll();
	}
	
	
	
	@GetMapping(value = "/etudiants/{id}")
	public Optional<Etudiant> getEtudiantById(@PathVariable long id){
		return etudiantRepos.findById(id);
	}
	
	
	@PostMapping(value = "/etudiants")
	public void addEtudiant(@RequestBody Etudiant etudiant) {
		etudiantRepos.save(etudiant);
	}
	
	@PatchMapping(value = "/update/etudiant/{id}")
	public void updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable long id) {
		
		etudiantRepos.save(etudiant);
	}
	
	
	@DeleteMapping(value = "/etudiant/{id}")
	public void deleteEtudiant(@PathVariable long id) {
		
		etudiantRepos.deleteById(id);
	}
	
	
//	@DeleteMapping(value = "/")
//	public void deleteAllEtudiants() {
//		etudiantRepos.deleteAll();
//	}
	
}
