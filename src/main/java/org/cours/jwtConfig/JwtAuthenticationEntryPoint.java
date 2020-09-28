package org.cours.jwtConfig;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint,Serializable{

	/**
	 * The purpose of this file is to handle exceptions and whenever 
	 * JWT  token is not validated it throws Unauthorised exception.
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
			
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, 	"UNauthorized");
		
	}

}
