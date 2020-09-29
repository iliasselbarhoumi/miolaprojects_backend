package com.miolaprojects.MiolaProjects.models;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class JwtRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NonNull private String username;
	@NonNull private String password;
	
}
