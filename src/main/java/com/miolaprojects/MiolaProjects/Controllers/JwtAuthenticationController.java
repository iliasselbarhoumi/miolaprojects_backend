package com.miolaprojects.MiolaProjects.Controllers;

import com.miolaprojects.MiolaProjects.Dao.DaoUser;
import com.miolaprojects.MiolaProjects.Dao.UserDao;
import com.miolaprojects.MiolaProjects.jwtConfig.JwtTokenUtil;
import com.miolaprojects.MiolaProjects.models.JwtRequest;
import com.miolaprojects.MiolaProjects.models.JwtResponse;
import com.miolaprojects.MiolaProjects.models.User;
import com.miolaprojects.MiolaProjects.Repos.JwtUserDetailsServices;
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
	public Iterable<?> getAllUsers(){
		return userDao.findAll();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/api/user")
	public DaoUser getUserByUsername(String username){
		return userDao.findByUsername(username);
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken( @RequestBody JwtRequest authenticationRequest) throws Exception {
		
		authenticate(authenticationRequest.getUsername(),authenticationRequest.getPassword());	
		
		final UserDetails userDetails = userDetailsService .loadUserByUsername(authenticationRequest.getUsername());
		
		//System.out.println("rrr "+userDetails+ " username "+authenticationRequest.getUsername());
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token, getRoleFromUsername(authenticationRequest.getUsername())));
	}
	
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception 
	{
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	
	public String getRoleFromUsername(String username) 
	{
		return userDao.findByUsername(username).getRole();
	}
	
	private void authenticate(String username, String password) throws Exception {
		
		try { authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(username, password)); } 
		
		catch (DisabledException e) 
		{ throw new Exception("USER_DISABLED", e);} 
		
		catch (BadCredentialsException e) 
		{ throw new Exception("INVALID_CREDENTIALS", e); }
	}
	
	
	
}
