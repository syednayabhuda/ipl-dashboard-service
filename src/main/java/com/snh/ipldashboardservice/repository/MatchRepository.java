package com.snh.ipldashboardservice.repository;

import com.snh.ipldashboardservice.model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> getByTeam1OrTeam2OrderByDateDesc(String team1, String team2, Pageable pageable);

    /*List<Match> getByTeam1AndDateBetweenOrTeam2AndDateBetweenOrderByDateDesc(
    String team1,
    LocalDate date1,
    LocalDate date2,
    String team2,
    LocalDate date3,
    LocalDate date4
    );*/
    @Query("SELECT m FROM Match m " +
            "WHERE (m.team1 = :teamName OR m.team2 = :teamName) AND (m.date BETWEEN :startDate AND :endDate) " +
            "ORDER BY m.date DESC")
    List<Match> getByTeamBetweenDates(
            @Param("teamName") String teamName,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    default List<Match> getLastNMatchDetails(String team1, String team2, int N) {
        return getByTeam1OrTeam2OrderByDateDesc(team1, team2, PageRequest.of(0, N));
    }
}
