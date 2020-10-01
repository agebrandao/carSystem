package com.project.ApiCarSystem.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.ApiCarSystem.Exceptions.FieldMessage;
import com.project.ApiCarSystem.entity.User;

public class UserValidation {
	
	private UserService userService;
	
	public UserValidation(UserService userService){
		this.userService = userService;
	}
	
    protected FieldMessage validateCreateUser(User user){
    
        if(validateEmailExists(user)){
        	return new FieldMessage("Email", "Email already exists", "");                       
        }
        
        if(validateLoginExists(user)){
        	return new FieldMessage("Login", "Login already exists", "");                       
        }
        
        return null;
    }
    
    protected FieldMessage validateUpdateUser(User user){
    	
    	 if(validateEmailExists(user)){
         	return new FieldMessage("Email", "Email already exists", "");                       
         }
         
         if(validateLoginExists(user)){
         	return new FieldMessage("Login", "Login already exists", "");                       
         }
         
        return null;
    }
    
    private Boolean validateEmailExists(User user){
    	
    	if(user.getEmail() != null){
    		User result = userService.findUserByEmail(user.getEmail());
    		if(result != null){
    			return true;
    		}
    	}
    	return false;
    }
    
    private Boolean validateLoginExists(User user){
    	
    	if(user.getLogin() != null){
    		User result = userService.findUserByLogin(user.getLogin());
    		if(result != null){
    			return true;
    		}
    	}
    	return false;
    }
    
 
}
