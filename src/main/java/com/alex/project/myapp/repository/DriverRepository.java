package com.alex.project.myapp.repository;

import com.alex.project.myapp.model.Driver;
import com.alex.project.myapp.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    // Find drivers by season
    List<Driver> findDriverBySeason(Integer season);

    // Find driver by season and ID
    Optional<Driver> findBySeasonAndId(Integer season, Long id);

    // Find drivers by season and team (case-insensitive)
    List<Driver> findBySeasonAndTeam(Integer season, Team team);

    // Get all available seasons ordered by year (newest first)
    @Query("SELECT DISTINCT d.season FROM Driver d ORDER BY d.season DESC")
    List<Integer> findDistinctSeasons();

    // Count drivers by season
    Long countBySeason(Integer season);

    // Find all teams in a specific season
    @Query("SELECT DISTINCT d.team.name FROM Driver d WHERE d.season = :season ORDER BY d.team.name")
    List<String> findDistinctTeamsBySeason(@Param("season") Integer season);
}
