package org.cours.model;



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
public class UserModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NonNull private String username;
	@NonNull private String password;
	@NonNull private String role;
	
}
