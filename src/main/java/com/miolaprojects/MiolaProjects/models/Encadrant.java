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
public class Encadrant {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NonNull
	private String Nom;
	@NonNull
	private String Prenom;
	@NonNull
	private String Role;
	@NonNull
	private String Departement;
	
}
