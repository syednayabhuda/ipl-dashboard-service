package com.snh.ipldashboardservice.controller;

import com.snh.ipldashboardservice.model.Match;
import com.snh.ipldashboardservice.model.Team;
import com.snh.ipldashboardservice.repository.MatchRepository;
import com.snh.ipldashboardservice.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@CrossOrigin
@RestController
public class DashboardController {

    @Autowired
    private TeamRepository teamRepo;

    @Autowired
    private MatchRepository matchRepo;

    @GetMapping("/teams")
    public Iterable<Team> getAllTeams() {
        return teamRepo.findAll();
    }

    @GetMapping("team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team team = teamRepo.findByTeamName(teamName);
        team.setMatches(matchRepo.getLastNMatchDetails(teamName, teamName, 4));
        return team;
    }

    @GetMapping("team/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
        LocalDate startDate = LocalDate.of(year, Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(year + 1, Month.JANUARY, 1);
        return matchRepo.getByTeamBetweenDates(teamName, startDate, endDate);
    }

}
