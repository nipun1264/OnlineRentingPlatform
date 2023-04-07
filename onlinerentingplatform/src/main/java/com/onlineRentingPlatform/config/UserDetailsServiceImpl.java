package com.onlineRentingPlatform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.onlineRentingPlatform.dao.UserRepository;
import com.onlineRentingPlatform.entities.User;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Fetching User From database
		
	User user = userRepository.getUserByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("Couldnot Found User");
	}
		 CustomUserDetails customUserDetails= new CustomUserDetails(user);
		return customUserDetails;
	}

}
