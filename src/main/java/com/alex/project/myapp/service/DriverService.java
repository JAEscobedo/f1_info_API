package com.alex.project.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.project.myapp.model.Driver;
import com.alex.project.myapp.repository.DriverRepository;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }

    public Driver createDriver(Driver driver){
        return driverRepository.save(driver);
    }

    public Optional<Driver> getDriverById(Long id){
       return driverRepository.findById(id);
    }

    public Optional<Driver> updateDriver(Long id, Driver driverDetails){
        Optional<Driver> driver = driverRepository.findById(id);

        if(driver.isPresent()){
            Driver existingDriver = driver.get();
            existingDriver.setFirstName(driverDetails.getFirstName());
            existingDriver.setLastName(driverDetails.getLastName());
            existingDriver.setTeam(driverDetails.getTeam());
            existingDriver.setNationality(driverDetails.getNationality());
            existingDriver.setDriverNumber(driverDetails.getDriverNumber());
            return Optional.of(driverRepository.save(existingDriver));
        } else {
            return Optional.empty();
        }
    }

    public Boolean deleteDriver(Long id){
        Optional<Driver> driver = driverRepository.findById(id);

        if(driver.isPresent()){
            driverRepository.delete(driver.get());
            return true;
        } else {
            return false;
        }
    }
}
