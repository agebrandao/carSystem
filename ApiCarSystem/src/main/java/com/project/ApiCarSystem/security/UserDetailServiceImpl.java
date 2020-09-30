package com.project.ApiCarSystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.ApiCarSystem.entity.User;
import com.project.ApiCarSystem.user.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		User user = userRepository.findByLogin(username);
		
		if(user == null){
			throw new UsernameNotFoundException(username);
		}
		return new UserSpringSecurity(user.getId(),user.getLogin(), user.getPassword());
	}
}
