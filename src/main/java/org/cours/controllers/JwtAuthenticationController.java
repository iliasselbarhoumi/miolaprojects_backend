package org.cours.controllers;


import java.util.List;

import org.cours.Dao.DaoUser;
import org.cours.Dao.UserDao;
import org.cours.jwtConfig.JwtTokenUtil;
import org.cours.model.JwtRequest;
import org.cours.model.JwtResponse;
import org.cours.model.UserModel;
import org.cours.repos.JwtUserDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JwtAuthenticationController {

	
	@Autowired
	private AuthenticationManager authenticationManager;	
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsServices userDetailsService;
	
	@Autowired
	private UserDao userDao;
	
	
	@GetMapping(value = "/users")
	public List<String> getAllUsers(){
		
		return userDao.getAllUsernames();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/api/user")
	public DaoUser getUserByUsername(String username){
	
		return userDao.findByUsername(username);
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(
			@RequestBody JwtRequest authenticationRequest)
			throws Exception {
		
		authenticate(authenticationRequest.getUsername(),
				authenticationRequest.getPassword());	
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		System.out.println("rrr "+userDetails+ " username "+authenticationRequest.getUsername());
		
		final String token = jwtTokenUtil.generateToken(userDetails);
				return ResponseEntity.ok(new JwtResponse(token, getRoleFromUsername(authenticationRequest.getUsername())));
	}
	
	public String getRoleFromUsername(String username) {
		
		return userDao.findByUsername(username).getRole();
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserModel user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			
			throw new Exception("USER_DISABLED", e);
				
		} catch (BadCredentialsException e) {
			
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	
	
}
