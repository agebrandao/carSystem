package com.project.ApiCarSystem.car;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.ApiCarSystem.Exceptions.FieldMessage;
import com.project.ApiCarSystem.entity.Car;

public class CarValidation {
	
	private CarService carService;
	
	public CarValidation(CarService carService){
		this.carService = carService;
	}
	
    protected FieldMessage validateCreateCar(Car car){
    
        if(validateLicensePlateExists(car)){
        	return new FieldMessage("license Plate", "License Plate already exists", "");                       
        }       
        
        return null;
    }
    
    protected FieldMessage validateUpdateCar(Car car){
    	
	   if(validateLicensePlateExists(car)){
       	return new FieldMessage("license Plate", "License Plate already exists", "");                       
       }   
         
       return null;
    }
    
    private Boolean validateLicensePlateExists(Car car){
    	
    	if(car.getLicensePlate() != null){
    		Car result = carService.findCarByLicensePlate(car.getLicensePlate());
    		if(result != null){
    			return true;
    		}
    	}
    	return false;
    }
    
 
}
