package com.project.ApiCarSystem.car;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.project.ApiCarSystem.entity.Car;
import com.project.ApiCarSystem.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/apiCarSystem/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> create( HttpServletRequest request, @RequestBody Car car, BindingResult result){

        try {
        	car.setId(null);
            validateCreateCar(car, result);
            if(result.hasErrors()){                        
                return ResponseEntity.badRequest().body(car);        
            }
            
            //Creates or updates the car
            Car carPersisted = (Car) carService.saveCar(car);
            return ResponseEntity.ok(carPersisted);            

        } catch (Exception e) {           
            return ResponseEntity.badRequest().body(car); 
            
        }
    }

    private void validateCreateCar(Car Car, BindingResult result){
        if(Car.getLicensePlate() == null){

            Car CarExists = carService.findCarByLicensePlate(Car.getLicensePlate());
            if (CarExists != null) {
                result.addError(new ObjectError("Car", "License plate no information"));
            }
        }
    }

    @PutMapping
    public ResponseEntity<Car> update( HttpServletRequest request, @RequestBody Car car, BindingResult result){

        try {
            validateUpdateCar(car, result);
            if(result.hasErrors()){                        
                return ResponseEntity.badRequest().body(car);        
            }
            
            //Creates or updates the car
            Car carPersisted = (Car) carService.saveCar(car);
            return ResponseEntity.ok(carPersisted);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(car); 
            
        }
    }

    private void validateUpdateCar(Car car, BindingResult result) {
		if (car.getId() == null) {
			result.addError(new ObjectError("Car", "Id no information"));
			return;
		}
		if (car.getLicensePlate() == null) {
			result.addError(new ObjectError("Car", "License car no information"));
			return;
		}
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