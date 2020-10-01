package com.project.ApiCarSystem.user;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.project.ApiCarSystem.entity.User;
import com.project.ApiCarSystem.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    //@PostMapping("/save")
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> create( HttpServletRequest request, @RequestBody User user, BindingResult result){
    	
        try {
        	user.setId(null);
            validateCreateUser(user, result);
            if(result.hasErrors()){                        
                return ResponseEntity.badRequest().body(user);        
            }
            
            //Creates or updates the user
            User userPersisted = (User) userService.saveUser(user);
            return ResponseEntity.ok(userPersisted);            

        } catch (Exception e) {           
            return ResponseEntity.badRequest().body(user); 
            
        }
    }

    private void validateCreateUser(User User, BindingResult result){
        if(User.getLogin() == null){

            User UserExists = userService.findUserByLogin(User.getLogin());
            if (UserExists != null) {
                result.addError(new ObjectError("User", "Login no information"));
            }
        }
    }

    @PutMapping
    public ResponseEntity<User> update( HttpServletRequest request, @RequestBody User user, BindingResult result){

        try {
            validateUpdateUser(user, result);
            if(result.hasErrors()){                        
                return ResponseEntity.badRequest().body(user);        
            }
            
            //Creates or updates the user
            User userPersisted = (User) userService.saveUser(user);
            return ResponseEntity.ok(userPersisted);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(user); 
            
        }
    }

    private void validateUpdateUser(User User, BindingResult result) {
		if (User.getId() == null) {
			result.addError(new ObjectError("User", "Id no information"));
			return;
		}
		if (User.getLogin() == null) {
			result.addError(new ObjectError("User", "Login no information"));
			return;
		}
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