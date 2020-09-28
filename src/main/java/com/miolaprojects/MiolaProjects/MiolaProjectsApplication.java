package com.miolaprojects.MiolaProjects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.miolaprojects.MiolaProjects.Repos.EncadrantRepository;
import com.miolaprojects.MiolaProjects.Repos.EtudiantRepository;
import com.miolaprojects.MiolaProjects.Repos.GroupeRepository;
import com.miolaprojects.MiolaProjects.Repos.ProjetRepository;
import com.miolaprojects.MiolaProjects.jwtConfig.JwtRequestFilter;
import com.miolaprojects.MiolaProjects.models.Encadrant;
import com.miolaprojects.MiolaProjects.models.Etudiant;
import com.miolaprojects.MiolaProjects.models.Groupe;
import com.miolaprojects.MiolaProjects.models.Projet;

@SpringBootApplication
public class MiolaProjectsApplication {

	@Autowired
	private ProjetRepository projetRepo;
	
	@Autowired
	private EncadrantRepository encadrantRepo;
	
	@Autowired
	private EtudiantRepository etudiantRepo;
	
	@Autowired
	private GroupeRepository groupeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(MiolaProjectsApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(){
	return args -> 
		{
			String[] TechP1 = {};
			String[] TechP2 = {"Photoshop", "Illustrator"};
			String[] TechP3 = {"Android Studio", "Firebase"};
			
			String[] RemarquesP1 = {};
			String[] RemarquesP2 = {};
			String[] RemarquesP3 = {};
			
			Projet p1 = new Projet("SmartZoo - Vision Board","projet consiste a élaborer une vison d'un projet.","SCRUM","15 jours",TechP1,RemarquesP1,0);
			Projet p2 = new Projet("SmartZoo - Vision Box","projet consiste a élaborer un box d'un projet.","SCRUM","20 jours",TechP2,RemarquesP2,0);
			Projet p3 = new Projet("HealthCare","projet consiste a élaborer une application de gestion d'un cabinet médical","Android","2 mois",TechP3,RemarquesP3,0);
			
			Encadrant e1 = new Encadrant("Ahmed","Rochdi","Encadrant","GI");
			Encadrant e2 = new Encadrant("Safae","Hilali","Encadrant","BigData");
			Encadrant e3 = new Encadrant("Naoual","Berbiche","Encadrant","Security");
			
			Etudiant et1 = new Etudiant("EL-FAKIR","Mohamed","1578999364","Miola","","","");
			Etudiant et2 = new Etudiant("EL BARHOUMI","Mohamed Iliass","M137320666","Miola","","","");
			Etudiant et3 = new Etudiant("SALIH","Samah","143784903","Miola","","","");
			Etudiant et4 = new Etudiant("ABDULRAHMAN","Ali Ibrahim","G56389X83","Miola","","","");
			
			Groupe g1 = new Groupe("IotGuys");
			Groupe g2 = new Groupe("Eagles");
			
			projetRepo.save(p1);
			projetRepo.save(p2);
			projetRepo.save(p3);
			
			encadrantRepo.save(e1);
			encadrantRepo.save(e2);
			encadrantRepo.save(e3);
			
			etudiantRepo.save(et1);
			etudiantRepo.save(et2);
			etudiantRepo.save(et3);
			etudiantRepo.save(et4);
			
			groupeRepo.save(g1);
			groupeRepo.save(g2);
		
		};
	}

}
