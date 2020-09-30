package com.project.ApiCarSystem.user;

import java.util.List;
import java.util.Optional;

import com.project.ApiCarSystem.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {

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

    public User saveUser(User user) {    	
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}