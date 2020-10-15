package com.miolaprojects.MiolaProjects.jwtConfig;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miolaprojects.MiolaProjects.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{


	
	/*
	 * The purpose of this file is to handle filtering the request from the client-side
	 *  or react js, here is where all the request will come first before hitting the rest API,
	 *  if the token validation is successful then actual API gets a request.

	 */
	
	@Autowired
	private JwtUserDetailsServices jwtUserDetailsServices;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
final String requestTokenHeader = request.getHeader("Authorization");
		
		System.out.println("ssssdd "+ requestTokenHeader);
		String username = null;
		String jwtToken = null;
		
//		JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        // JWT Token is in the form "Bearer token". 
        //Remove Bearer word and get only the Token
	if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) 
//		if (requestTokenHeader != null) 
			   
	{
		jwtToken = requestTokenHeader.substring(7);
		System.out.println("current toekn "+jwtToken);
		
		username = jwtTokenUtil.getUsernameFromToken(jwtToken);
		 if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

	            UserDetails userDetails = this.jwtUserDetailsServices.loadUserByUsername(username);

	            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

	                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
	                        userDetails, null, userDetails.getAuthorities());
	                usernamePasswordAuthenticationToken
	                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	            }
	        }
			} 
			chain.doFilter(request, response);
		}
	
	
	

}
