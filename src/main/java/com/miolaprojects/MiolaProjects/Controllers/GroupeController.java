package com.miolaprojects.MiolaProjects.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miolaprojects.MiolaProjects.Repos.GroupeRepository;
import com.miolaprojects.MiolaProjects.models.Groupe;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class GroupeController {
	
	@Autowired
	private GroupeRepository groupeRepo;
	
	@RequestMapping("/groupes")
	public Iterable<Groupe> getGroupes() 
	{
		return groupeRepo.findAll();
	}
	
	@RequestMapping("/groupes/{id}")
	public Optional<Groupe> getGroupe(@PathVariable Long id) 
	{
		return groupeRepo.findById(id);
	}
	
	@RequestMapping( method = RequestMethod.POST, value = "/groupes")
	public void addGroupe(@RequestBody Groupe groupe) 
	{
		groupeRepo.save(groupe);
	}
	
	@RequestMapping( method = RequestMethod.PUT, value = "/groupes/{id}")
	public void modifyGroupe(@RequestBody Groupe groupe,@PathVariable Long id) 
	{
		groupeRepo.save(groupe);
	}
	
	@RequestMapping( method = RequestMethod.PATCH, value = "/groupes/{id}")
	public void editGroupe(@RequestBody Groupe groupe,@PathVariable Long id) 
	{
		groupeRepo.save(groupe);
	}
	
	@RequestMapping( method = RequestMethod.DELETE, value = "/groupes/{id}")
	public void deleteGroupe(@PathVariable Long id) 
	{
		groupeRepo.deleteById(id);
	}
	

}
