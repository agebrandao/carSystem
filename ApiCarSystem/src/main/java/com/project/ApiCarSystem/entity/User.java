package com.project.ApiCarSystem.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

	@Column(name = "firstName")
    @Size(max = 30, message="Maximum size 30 caracters")
    private String firstName;
    
    @Column(name = "lastName")
    @Size(max = 30, message="Maximum size 30 caracters")
    private String lastName;
    
    @Column(name = "email")
    @Email(message = "Invalid field: Please provide a valid Email")
    @Size(max = 30, message="Maximum size 30 caracters")
    private String email;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone")
    @Size(max = 15, message="Maximum size 15 caracters")
    private String phone;
    
    @Column(name = "login")
    @NotEmpty(message = "Missing field: Please provide your login")
    @Size(max = 15, message="Maximum size 15 caracters")
    private String login;

    //@JsonIgnore
    @Column(name = "password")
    //@NotEmpty(message = "Please provide your password")
    @Size(max = 100, message="Maximum size 100 caracters")
    private String password;

	@OneToMany 
    Set<Car> cars;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}    
	
	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
}