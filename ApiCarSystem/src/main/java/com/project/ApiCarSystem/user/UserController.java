package com.project.ApiCarSystem.user;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.project.ApiCarSystem.Exceptions.FieldMessage;
import com.project.ApiCarSystem.entity.User;
import com.project.ApiCarSystem.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiCarSystem/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping()
	public ResponseEntity<Object> create(@Valid @RequestBody User user, Errors errors) {
    	
    	FieldMessage fieldMessage = null;
    	
    	try{    		
    		fieldMessage = new UserValidation(userService).validateCreateUser(user);    	
    		
    		if(fieldMessage == null){
		    	User userPersisted = (User) userService.saveUser(user);
		    	return ResponseEntity.ok(userPersisted); 
    		}
	    	
    	}catch(Exception e){  
    		if(errors != null && errors.hasErrors() && fieldMessage == null){
    			fieldMessage = new FieldMessage(errors.getFieldError().getField(), errors.getFieldError().getDefaultMessage(), errors.getFieldError().getCode() );
    		}else{
    			return ResponseEntity.badRequest().body(new FieldMessage("Exception", e.getMessage(), ""));
    		}
    	}    	
    	
    	return ResponseEntity.badRequest().body(fieldMessage);
        
	}

    @PutMapping
    public ResponseEntity<Object> update( HttpServletRequest request, @RequestBody User user, Errors errors){

    	FieldMessage fieldMessage = null;
    	
    	try{    		
    		fieldMessage = new UserValidation(userService).validateUpdateUser(user);    	
    		
    		if(fieldMessage == null){
		    	User userPersisted = (User) userService.saveUser(user);
		    	return ResponseEntity.ok(userPersisted); 
    		}
	    	
    	}catch(Exception e){  
    		if(errors != null && errors.hasErrors() && fieldMessage == null){
    			fieldMessage = new FieldMessage(errors.getFieldError().getField(), errors.getFieldError().getDefaultMessage(),errors.getFieldError().getCode());
    		}else{
    			return ResponseEntity.badRequest().body(new FieldMessage("Exception", e.getMessage(), ""));
    		}
    	}    	
    	
    	return ResponseEntity.badRequest().body(fieldMessage);
    }
    
    @DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {

		Optional<User> opUser = userService.findUserById(id);
		User User =  opUser.get();

		if (User == null) {
			return ResponseEntity.badRequest().body("Register not found id: "  + User); 
		}
        userService.deleteUser(User);
    
		return ResponseEntity.ok("Register found id: " + User);
	}

    @GetMapping
	public ResponseEntity<List<User>> findByAll() {

		List<User> users = userService.findAllUser();	

		if (users == null) {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(users);    

    }

    @GetMapping(value = "{id}")
	public ResponseEntity<User> findById(@PathVariable("id") Long id) {

		Optional<User> opUser = userService.findUserById(id);
		User user =  opUser.get();

		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(user);
    }
    
    @GetMapping(value = "/login/{login}")
	public ResponseEntity<User> findByLogin(String login) {

		User user = userService.findUserByLogin(login);		

		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(user);
	}

}