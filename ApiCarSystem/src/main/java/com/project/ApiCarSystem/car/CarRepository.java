package com.project.ApiCarSystem.car;

import java.util.List;
import java.util.Optional;

import com.project.ApiCarSystem.entity.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findById(@PathVariable String id);    
    List<Car> findAll();
    Car findByLicensePlate(String licensePlate);
    Car findByModel(String model);
}