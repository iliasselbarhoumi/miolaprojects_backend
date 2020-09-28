package org.cours.repos;

import java.util.ArrayList;

import org.cours.Dao.DaoUser;
import org.cours.Dao.UserDao;
import org.cours.model.UserModel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class JwtUserDetailsServices implements UserDetailsService{

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//To validate username and password and return user details object.
		
		DaoUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
		
//		if ("javainuse".equals(username)) {
//			return new User("javainuse",
//					"$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
	}
	

	public DaoUser save(UserModel user) {
		
		DaoUser newUser = new DaoUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		
		return userDao.save(newUser);
	}
	
}
