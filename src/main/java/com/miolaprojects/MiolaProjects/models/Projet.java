package com.miolaprojects.MiolaProjects.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
public class Projet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NonNull
	private String Titre;
	@NonNull
	private String Description;
	@NonNull
	private String Theme;
	@NonNull
	private String Duree;
	@NonNull
	private String[] Technologies;
	@NonNull
	private String[] Remarques;
	@NonNull
	private double Note;
	
	

	

}
