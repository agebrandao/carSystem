package com.project.ApiCarSystem.car;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.project.ApiCarSystem.entity.Car;
import com.project.ApiCarSystem.entity.Car;
import com.project.ApiCarSystem.car.CarValidation;
import com.project.ApiCarSystem.Exceptions.FieldMessage;
import com.project.ApiCarSystem.car.CarService;
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
@RequestMapping("/apiCarSystem/cars")
public class CarController {

    @Autowired
    private CarService carService;
    
    @PostMapping()
	public ResponseEntity<Object> create(@Valid @RequestBody Car car, Errors errors) {
    	
    	FieldMessage fieldMessage = null;
    	
    	try{    		
    		fieldMessage = new CarValidation(carService).validateCreateCar(car);    	
    		
    		if(fieldMessage == null){
		    	Car carPersisted = (Car) carService.saveCar(car);
		    	return ResponseEntity.ok(carPersisted); 
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
    public ResponseEntity<Object> update( HttpServletRequest request, @RequestBody Car car, Errors errors){

    	FieldMessage fieldMessage = null;
    	
    	try{    		
    		fieldMessage = new CarValidation(carService).validateUpdateCar(car);    	
    		
    		if(fieldMessage == null){
		    	Car carPersisted = (Car) carService.saveCar(car);
		    	return ResponseEntity.ok(carPersisted); 
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
    
    @DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {

		Optional<Car> opCar = carService.findCarById(id);
		Car car =  opCar.get();

		if (car == null) {
			return ResponseEntity.badRequest().body("Register not found id: "  + car); 
		}
        carService.deleteCar(car);
    
		return ResponseEntity.ok("Register found id: " + car);
	}

    @GetMapping
	public ResponseEntity<List<Car>> findByAll() {

		List<Car> cars = carService.findAllCar();	

		if (cars == null) {
			return new ResponseEntity<List<Car>>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(cars);    

    }

    @GetMapping(value = "{id}")
	public ResponseEntity<Car> findById(@PathVariable("id") Long id) {

		Optional<Car> opCar = carService.findCarById(id);
		Car car =  opCar.get();

		if (car == null) {
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(car);
    }
    
    @GetMapping(value = "LicensePlate/{licensePlate}")
	public ResponseEntity<Car> findByLicensePlate(String licensePlate) {

		Car car = carService.findCarByLicensePlate(licensePlate);		

		if (car == null) {
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(car);
	}

}