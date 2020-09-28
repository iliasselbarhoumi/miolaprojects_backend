package org.cours.Dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name = "user")
public class DaoUser {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NonNull @Column private String username;
	@NonNull @Column private String password;
	@NonNull @Column @JsonIgnore private String role;
	
	
	

}
