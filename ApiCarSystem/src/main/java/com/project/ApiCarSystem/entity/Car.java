package com.project.ApiCarSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.test.context.jdbc.Sql;

@Entity
@Table(name = "car")
@Sql(statements="CREATE SCHEMA IF NOT EXISTS DUMMY")
public class Car {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;
	
	@Column(name = "year")
    private Integer year;    

	@Column(name = "licensePlate")
    @NotEmpty(message = "Please provide the car license Plate")
	@Size(max = 8, message="Maximum size 8 caracters")
    private String licensePlate;
   
	@Column(name = "model")    
	@Size(max = 15, message="Maximum size 15 caracters")
    private String model;
    
    @Column(name = "color")
    @Size(max = 15, message="Maximum size 15 caracters")
    private String color;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
