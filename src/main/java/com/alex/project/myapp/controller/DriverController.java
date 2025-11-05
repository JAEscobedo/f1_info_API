package com.alex.project.myapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.project.myapp.model.Driver;
import com.alex.project.myapp.repository.DriverRepository;



@RestController
@RequestMapping("/api/v1/f1_info/drivers")
@CrossOrigin(origins = "*")
public class DriverController {
    @Autowired
    private DriverRepository driverRepository;

    // Get all drivers
    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    // Create a new driver
    @PostMapping 
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        Driver savedDriver = driverRepository.save(driver);
        return ResponseEntity.created(null).body(savedDriver);
    }

    // Get driver by ID
    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        Optional<Driver> driver = driverRepository.findById(id);
        if (driver.isPresent()) {
            return ResponseEntity.ok(driver.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driverDetails) {
        Optional<Driver> driver = driverRepository.findById(id);

        if(driver.isPresent()){
            Driver existingDriver = driver.get();
            existingDriver.setFirstName(driverDetails.getFirstName());
            existingDriver.setLastName(driverDetails.getLastName());
            existingDriver.setTeam(driverDetails.getTeam());
            existingDriver.setNationality(driverDetails.getNationality());
            existingDriver.setDriverNumber(driverDetails.getDriverNumber());
            Driver updatedDriver = driverRepository.save(existingDriver);
            return ResponseEntity.ok(updatedDriver);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        Optional<Driver> driver = driverRepository.findById(id);

        if(driver.isPresent()){
            driverRepository.delete(driver.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }    
    
}
