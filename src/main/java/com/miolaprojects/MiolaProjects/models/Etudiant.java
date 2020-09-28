package com.miolaprojects.MiolaProjects.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Etudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NonNull private String nom;
	@NonNull private String prenom;
	@NonNull private String cne;
	@NonNull private String filiere;
	@NonNull private String groupKey;
	@NonNull private String EncadrantId;
	@NonNull private String projectId;
	
}
