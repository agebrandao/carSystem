package com.project.ApiCarSystem.user;

import java.util.List;
import java.util.Optional;

import com.project.ApiCarSystem.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder cryptPassword;
	
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findUserByFirstName(String firstname) {
        return userRepository.findByFirstName(firstname);
    }

    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }
    
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {  
    	if(user.getId() == null || (user.getId() != null && user.getPassword() != null)){
    		user.setPassword(cryptPassword.encode(user.getPassword()));
    	}
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}