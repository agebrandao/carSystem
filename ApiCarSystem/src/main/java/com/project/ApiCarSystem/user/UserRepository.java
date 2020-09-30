package com.project.ApiCarSystem.user;

import java.util.List;
import java.util.Optional;

import com.project.ApiCarSystem.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(@PathVariable String id);    
    List<User> findAll();
    User findByFirstName(String firstname);
    User findByLogin(String login);
}