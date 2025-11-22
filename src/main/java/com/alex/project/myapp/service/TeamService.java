package com.alex.project.myapp.service;

import com.alex.project.myapp.model.Team;
import com.alex.project.myapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team getTeamByName(String teamName) {
        return teamRepository.findTeamByName(teamName);
    }
}
