package com.miolaprojects.MiolaProjects.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miolaprojects.MiolaProjects.Repos.EtudiantRepository;
import com.miolaprojects.MiolaProjects.models.Etudiant;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EtudiantController {


	@Autowired
	EtudiantRepository etudiantRepos;
	
	
	@RequestMapping("/etudiants")
	public Iterable<Etudiant> getAllEtudiants(){
		return etudiantRepos.findAll();
	}
	
	@RequestMapping("/etudiants/{id}")
	public Optional<Etudiant> getEtudiantById(@PathVariable long id){
		return etudiantRepos.findById(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST , value = "/etudiants")
	public void addEtudiant(@RequestBody Etudiant etudiant) {
		etudiantRepos.save(etudiant);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value = "/etudiants/{id}")
	public void updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable long id) {
		etudiantRepos.save(etudiant);
	}
	
	@RequestMapping(method = RequestMethod.PATCH , value = "/etudiants/{id}")
	public void modifyEtudiant(@RequestBody Etudiant etudiant, @PathVariable long id) {
		etudiantRepos.save(etudiant);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/etudiants/{id}")
	public void deleteEtudiant(@PathVariable long id) {
		etudiantRepos.deleteById(id);
	}
}
