package com.snh.ipldashboardservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Match {
    @Id
    private long id;
    private String city;
    private LocalDate date;

    /* private String season;
     private String matchNumber;*/
    private String venue;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;

    /* private String superOver;*/
    private String winningTeam;
    private String wonBy;//result
    private String margin;

    /*    private String method;*/
    private String playerOfMatch;

    /* private String team1Players;
     private String team2Players;*/
    private String umpire1;
    private String umpire2;
}
