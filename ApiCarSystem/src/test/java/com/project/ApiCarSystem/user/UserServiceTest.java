package com.project.ApiCarSystem.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.assertj.core.api.Assertions.assertThat;

import com.project.ApiCarSystem.entity.User;

import java.util.Optional;


@SpringBootTest
public class UserServiceTest {
	
	 @Autowired
	 private UserService service;
	 
	 private User user;
	 
	@BeforeTestClass
	void deleteAll() {		
		service.deleteAll();		
	}
	 
	@BeforeEach
	void objUser() {		
		user = new User();		
		user.setFirstName("Maria");
		user.setLastName("Silva");
		user.setEmail("maria@gmail.com");
		user.setLogin("MariaLogin");
		
	}
	
	    
	@Test
	@DisplayName("Test create user")
    public void createUser() throws Exception {
		
		user.setPassword("123456");
		
		service.saveUser(user);	
		
		Optional<User> opUser = service.findUserById(new Long(1));
		User userResult =  opUser.get();		
     	 
		Assertions.assertEquals(userResult.getId(), 1);		
	    Assertions.assertEquals(userResult.getEmail(), "maria@gmail.com");
  
    }
	
	@Test
	@DisplayName("Test update user")
    public void updateUser() throws Exception {		
		
		user.setId(new Long("1"));
		user.setLogin("MariaLogin1");		
		
		service.saveUser(user);	
		
		Optional<User> opUser = service.findUserById(new Long(1));
		User userResult =  opUser.get();		
     	 
		Assertions.assertEquals(userResult.getId(), 1);
	    Assertions.assertEquals(userResult.getLogin(), "MariaLogin1");
     	          		
    }
	
	@Test
	@DisplayName("Test delete user")
    public void deleteUser() throws Exception {					
		user.setId(new Long(1));				
		service.deleteUser(user);	   
		Optional<User> opUser = service.findUserById(new Long(1));
		assertThat(opUser).isEmpty();
    }
	

}
