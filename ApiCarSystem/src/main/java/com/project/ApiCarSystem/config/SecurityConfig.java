package com.project.ApiCarSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.project.ApiCarSystem.security.JWTAuthenticationFilter;
import com.project.ApiCarSystem.security.JWTAuthorizationFilter;
import com.project.ApiCarSystem.security.JwtUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
    private static final String[] PUBLIC_MATCHES = {
    		"/h2/**",    		
    		"/apiCarSystem/users/**"
    };
    
    @Override
	protected void configure(HttpSecurity http) throws Exception {
    	
    	//access h2 console
    	http.headers().frameOptions().disable();
    	
		http.cors().and().csrf().disable();
		
		//Url authorization
    	http.authorizeRequests()
			.antMatchers(PUBLIC_MATCHES)
			.permitAll()
			.anyRequest()
			.authenticated();
    	
    	http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
    	http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
    	
    	//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
           	
	}    
    
    @Override
   	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
    
    @Bean 
    CorsConfigurationSource corsConfigurationSource(){    	
    	final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
    	
    	return source;
    }  
    
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
    	return new BCryptPasswordEncoder();
    }
}


