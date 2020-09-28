package org.cours.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Setter
public class Encadrant {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	private long id;
	
	@NonNull private String nom;
	@NonNull private String prenom;
	@NonNull private String role;
	@NonNull private String departement;
	
	
}
