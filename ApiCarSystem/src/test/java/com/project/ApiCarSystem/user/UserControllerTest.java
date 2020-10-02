package com.project.ApiCarSystem.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ApiCarSystem.entity.User;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
	    
	@Test
	@DisplayName("Test create user")
    public void createUser() throws Exception {
		
		User user = new User();
		user.setId(null);
		user.setFirstName("Maria");
		user.setLastName("Silva");
		user.setEmail("maria@gmail.com");
		user.setLogin("MariaLogin");
		user.setPassword("123456");
		
		mockMvc.perform(post("/apiCarSystem/users")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(objectMapper.writeValueAsString(user)))
	            .andExpect(status().isOk())
	            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	            .andExpect(jsonPath("login", is("MariaLogin")));
		
    }
	
	@Test
	@DisplayName("Test update user")
    public void updateUser() throws Exception {		
		
		User user = new User();
		user.setId(new Long(1));
		user.setLogin("MariaLogin1");
		
		mockMvc.perform(put("/apiCarSystem/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("id", is(1)))
            .andExpect(jsonPath("login", is("MariaLogin1")));
     	          		
    }
	
	@Test
	@DisplayName("Test get user by id")
    public void getUserById() throws Exception {		
	    
        mockMvc.perform(get("/apiCarSystem/users/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))             
            .andExpect(jsonPath("id", is(1)));            
		
    }

}
