package org.cours.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class JwtResponse implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NonNull private final String jwttoken;
	@NonNull private final String role;
	
	
	
}
