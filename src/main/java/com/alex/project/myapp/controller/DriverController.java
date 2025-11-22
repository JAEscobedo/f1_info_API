package com.alex.project.myapp.controller;

import com.alex.project.myapp.model.Driver;
import com.alex.project.myapp.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/f1_info")
@CrossOrigin(origins = "*")
public class DriverController {
    @Autowired
    private DriverService driverService;

    // ===== SEASON-BASED ENDPOINTS =====

    // Get all available seasons
    @GetMapping("/seasons")
    public ResponseEntity<List<Integer>> getAvailableSeasons() {
        List<Integer> seasons = driverService.getAvailableSeasons();
        return ResponseEntity.ok(seasons);
    }

    // Get drivers by season
    @GetMapping("/seasons/{season}/drivers")
    public ResponseEntity<List<Driver>> getDriversBySeason(@PathVariable Integer season) {
        List<Driver> drivers = driverService.getDriversBySeason(season);
        if (drivers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(drivers);
    }

    // Get specific driver in a season
    @GetMapping("/seasons/{season}/drivers/{driverId}")
    public ResponseEntity<Driver> getDriverBySeasonAndId(
            @PathVariable Integer season,
            @PathVariable Long driverId) {
        Optional<Driver> driver = driverService.getDriverBySeasonAndId(season, driverId);
        return driver
                .map(d -> ResponseEntity.ok(d))
                .orElse(ResponseEntity.notFound().build());
    }

    // Get drivers by team in specific season
    @GetMapping("/seasons/{season}/teams/{team}/drivers")
    public ResponseEntity<List<Driver>> getDriversBySeasonAndTeam(
            @PathVariable Integer season,
            @PathVariable String team) {
        List<Driver> drivers = driverService.getDriversBySeasonAndTeam(season, team);
        if (drivers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(drivers);
    }

    // Get all teams in a specific season
    @GetMapping("/seasons/{season}/teams")
    public ResponseEntity<List<String>> getTeamsBySeason(@PathVariable Integer season) {
        List<String> teams = driverService.getTeamsBySeason(season);
        if (teams.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teams);
    }

    // Get season statistics
    @GetMapping("/seasons/{season}/stats")
    public ResponseEntity<Map<String, Object>> getSeasonStats(@PathVariable Integer season) {
        Map<String, Object> stats = driverService.getSeasonStatistics(season);
        return ResponseEntity.ok(stats);
    }

    // ===== CURRENT SEASON ENDPOINTS (2024) =====

    // Get current season drivers (defaults to 2024)
    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> getCurrentSeasonDrivers() {
        List<Driver> drivers = driverService.getCurrentSeasonDrivers();
        return ResponseEntity.ok(drivers);
    }

    // ===== LEGACY/ADMIN ENDPOINTS =====

    // Get all drivers (all seasons) - mainly for admin purposes
    @GetMapping("/drivers/all")
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        return ResponseEntity.ok(drivers);
    }

    // Create a new driver
    @PostMapping("/drivers")
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        Driver savedDriver = driverService.createDriver(driver);
        return ResponseEntity.created(null).body(savedDriver);
    }

    // Get driver by ID (regardless of season)
    @GetMapping("/drivers/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        Optional<Driver> driverO = driverService.getDriverById(id);
        return driverO
                .map(driver -> ResponseEntity.ok(driver))
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a driver
    @PutMapping("/drivers/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driverDetails) {
        Optional<Driver> updatedDriver = driverService.updateDriver(id, driverDetails);
        return updatedDriver
                .map(driver -> ResponseEntity.ok(driver))
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a driver
    @DeleteMapping("/drivers/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        Boolean deleted = driverService.deleteDriver(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
