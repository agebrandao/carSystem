package com.project.ApiCarSystem.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.test.context.jdbc.Sql;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
@Sql(statements="CREATE SCHEMA IF NOT EXISTS DUMMY")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

	@Column(name = "firstName")
    //@NotEmpty(message = "*Please provide your first name")
    @Size(max = 30)
    private String firstName;
    
    @Column(name = "lastName")
    //@NotEmpty(message = "*Please provide your last name")
    @Size(max = 30)
    private String lastName;
    
    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    //@NotEmpty(message = "*Please provide an email")
    @Size(max = 30)
    private String email;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone")
    //@NotEmpty(message = "*Please provide your telephone")
    @Size(max = 12)
    private String phone;
    
    @Column(name = "login")
    //@NotEmpty(message = "*Please provide your login")
    @Size(max = 15)
    private String login;

    @Column(name = "password")
    //@NotEmpty(message = "*Please provide your password")
    @Size(max = 8)
    private String password;
    
    //@JsonIgnore
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