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
@RequestMapping("/ApiCarSystem/car")
@CrossOrigin(origins = "*") //Access from any port
public class CarController {

    @Autowired
    private CarService CarService;

    @PostMapping
    public ResponseEntity<Car> create( HttpServletRequest request, @RequestBody Car car, BindingResult result){

        try {
            validateCreateCar(car, result);
            if(result.hasErrors()){                        
                return ResponseEntity.badRequest().body(car);        
            }
            
            //Creates or updates the car
            Car carPersisted = (Car) CarService.saveCar(car);
            return ResponseEntity.ok(carPersisted);            

        } catch (Exception e) {           
            return ResponseEntity.badRequest().body(car); 
            
        }
    }

    private void validateCreateCar(Car Car, BindingResult result){
        if(Car.getLicensePlate() == null){

            Car CarExists = CarService.findCarByLicensePlate(Car.getLicensePlate());
            if (CarExists != null) {
                result.addError(new ObjectError("Car", "License plate no information"));
            }
        }
    }

    @PutMapping
    public ResponseEntity<Car> update( HttpServletRequest request, @RequestBody Car Car, BindingResult result){

        try {
            validateUpdateCar(Car, result);
            if(result.hasErrors()){                        
                return ResponseEntity.badRequest().body(Car);        
            }
            
            //Creates or updates the car
            Car CarPersisted = (Car) CarService.saveCar(Car);
            return ResponseEntity.ok(CarPersisted);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Car); 
            
        }
    }

    private void validateUpdateCar(Car Car, BindingResult result) {
		if (Car.getId() == null) {
			result.addError(new ObjectError("Car", "Id no information"));
			return;
		}
		if (Car.getLicensePlate() == null) {
			result.addError(new ObjectError("Car", "License car no information"));
			return;
		}
    }
    
    @DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {

		Optional<Car> opCar = CarService.findCarById(id);
		Car Car =  opCar.get();

		if (Car == null) {
			return ResponseEntity.badRequest().body("Register not found id: "  + Car); 
		}
        CarService.deleteCar(Car);
    
		return ResponseEntity.ok("Register found id: " + Car);
	}

    @GetMapping
	public ResponseEntity<List<Car>> findByAll() {

		List<Car> cars = CarService.findAllCar();	

		if (cars == null) {
			return new ResponseEntity<List<Car>>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(cars);    

    }

    @GetMapping(value = "{id}")
	public ResponseEntity<Car> findById(@PathVariable("id") String id) {

		Optional<Car> opCar = CarService.findCarById(id);
		Car Car =  opCar.get();

		if (Car == null) {
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(Car);
    }
    
    @GetMapping(value = "{licensePlate}")
	public ResponseEntity<Car> findByLicensePlate(String licensePlate) {

		Car Car = CarService.findCarByLicensePlate(licensePlate);		

		if (Car == null) {
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(Car);
	}

}