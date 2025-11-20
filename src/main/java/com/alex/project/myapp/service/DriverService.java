package com.alex.project.myapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.project.myapp.model.Driver;
import com.alex.project.myapp.repository.DriverRepository;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    // Legacy methods (for backward compatibility)
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
            existingDriver.setSeason(driverDetails.getSeason());
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

    // New season-based methods
    public List<Driver> getDriversBySeason(Integer season) {
        return driverRepository.findDriverBySeason(season);
    }

    public Optional<Driver> getDriverBySeasonAndId(Integer season, Long id) {
        return driverRepository.findBySeasonAndId(season, id);
    }

    public List<Driver> getDriversBySeasonAndTeam(Integer season, String team) {
        return driverRepository.findBySeasonAndTeamIgnoreCase(season, team);
    }

    public List<Integer> getAvailableSeasons() {
        return driverRepository.findDistinctSeasons();
    }

    public List<String> getTeamsBySeason(Integer season) {
        return driverRepository.findDistinctTeamsBySeason(season);
    }

    public Map<String, Object> getSeasonStatistics(Integer season) {
        Map<String, Object> stats = new HashMap<>();
        stats.put("season", season);
        stats.put("drivers", driverRepository.findDriverBySeason(season));
        stats.put("totalDrivers", driverRepository.countBySeason(season));
        stats.put("teams", driverRepository.findDistinctTeamsBySeason(season));
        stats.put("totalTeams", driverRepository.findDistinctTeamsBySeason(season).size());
        return stats;
    }

    // Current season methods (defaults to 2024)
    public List<Driver> getCurrentSeasonDrivers() {
        return getDriversBySeason(2024);
    }
}
