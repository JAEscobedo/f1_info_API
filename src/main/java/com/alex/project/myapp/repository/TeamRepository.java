package com.alex.project.myapp.repository;

import com.alex.project.myapp.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findTeamById(Long id);

    Team findTeamByName(String name);
}
