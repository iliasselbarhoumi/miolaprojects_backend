package org.cours;

import org.cours.model.Encadrant;
import org.cours.model.Etudiant;
import org.cours.repos.EncadrantRepos;
import org.cours.repos.EtudiantRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MiolaProjectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiolaProjectsApplication.class, args);
	}

	
	@Autowired
	EncadrantRepos encadrantRepo;
	
	@Autowired
	EtudiantRepos etuRepos;
	
	
	@Bean
	CommandLineRunner runner() {
		
		return args -> {
			
			

			Encadrant encadrant = new Encadrant(1L,"med", "fakir", "Admin", "AI");
			Encadrant encadrant1 = new Encadrant(2L,"s!", "s", "ss", "ss");
			Encadrant encadrant2 = new Encadrant(3L,"s2", "s", "ss", "ss");
			Encadrant encadrant3 = new Encadrant(4L,"s3", "sd", "dss", "dss");
			

			encadrantRepo.save(encadrant);
			encadrantRepo.save(encadrant3);
			encadrantRepo.save(encadrant2);
			encadrantRepo.save(encadrant1);
			
			Etudiant etudiant = new Etudiant("dd", "sss", "ss","MIOLA", "sss", "ww", "ss");

			Etudiant etudiant1 = new Etudiant("qdd", "ssss", "wss","M3S", "dsss", "dww", "dss");
			
			etuRepos.save(etudiant);
			etuRepos.save(etudiant1);
			
			
			
		};
	}
}
