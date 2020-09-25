package com.miolaprojects.MiolaProjects.Controllers;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miolaprojects.MiolaProjects.Repos.ProjetRepository;
import com.miolaprojects.MiolaProjects.models.Projet;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProjetController {

	
	@Autowired
	private ProjetRepository projetRepository;
	
	@RequestMapping("/projets")
	public Iterable<Projet> getVoitures() 
	{
		return projetRepository.findAll();
	}
	
	@RequestMapping("/projets/{id}")
	public Optional<Projet> getVoiture(@PathVariable Long id) 
	{
		return projetRepository.findById(id);
	}
	
	@RequestMapping( method = RequestMethod.POST, value = "/projets")
	public void addProjet(@RequestBody Projet projet) 
	{
		projetRepository.save(projet);
	}
	
	@RequestMapping( method = RequestMethod.PUT, value = "/projets/{id}")
	public void modifyProjet(@RequestBody Projet projet,@PathVariable Long id) 
	{
		projetRepository.save(projet);
	}
	
	@RequestMapping( method = RequestMethod.PATCH, value = "/projets/{id}")
	public void editProjet(@RequestBody Projet projet,@PathVariable Long id) 
	{
		projetRepository.save(projet);
	}
	
	@RequestMapping( method = RequestMethod.DELETE, value = "/projets/{id}")
	public void deleteProjet(@PathVariable Long id) 
	{
		projetRepository.deleteById(id);
	}
}
