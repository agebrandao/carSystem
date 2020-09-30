package com.project.ApiCarSystem.car;

import java.util.List;
import java.util.Optional;

import com.project.ApiCarSystem.entity.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Optional<Car> findCarById(@PathVariable Long id) {
        return carRepository.findById(id);
    }

    public List<Car> findAllCar() {
        return carRepository.findAll();
    }

    public Car findCarByModel(String model) {
        return carRepository.findByModel(model);
    }

    public Car findCarByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Car car) {
        carRepository.delete(car);
    }

}