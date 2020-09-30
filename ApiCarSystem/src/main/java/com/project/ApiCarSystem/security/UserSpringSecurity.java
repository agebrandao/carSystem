package com.project.ApiCarSystem.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSpringSecurity implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String login;
	private String password;
	//private Collection<? extends GrantedAuthority> authorities;
	
	public UserSpringSecurity(){
	}
	
	public UserSpringSecurity(Long id, String login, String password
			){//,Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		//this.authorities = authorities;
	}

	public Long getId(){
		return id;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {	
		//return authorities;
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {		
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {		
		return true;
	}

	@Override
	public boolean isEnabled() {	
		return true;
	}

}
