package com.project.ApiCarSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	//@Autowired
	//private Environment env;
	
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
			.permitAll();
			//.anyRequest()
			//.authenticated();
    	
    	//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
           	
	}    
    
    @Bean 
    CorsConfigurationSource corsConfigurationSource(){    	
    	final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
    	
    	return source;
    }  
}


