package com.snh.ipldashboardservice.data;

import com.snh.ipldashboardservice.model.Match;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    @Override
    public Match process(final MatchInput matchInput) {
        Match match = new Match();
        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());
        match.setDate(LocalDate.parse(matchInput.getDate()));
        match.setVenue(matchInput.getVenue());
        //set team1 and team2 based on batting order
        String teamBatting1st, teamBatting2nd;
        if ("bat".equalsIgnoreCase(matchInput.getTossDecision())) {
            teamBatting1st = matchInput.getTossWinner();
            teamBatting2nd = matchInput.getTossWinner().equalsIgnoreCase(matchInput.getTeam1())
                    ? matchInput.getTeam2() : matchInput.getTeam1();
        }
        else {
            teamBatting2nd = matchInput.getTossWinner();
            teamBatting1st = matchInput.getTossWinner().equalsIgnoreCase(matchInput.getTeam1())
                    ? matchInput.getTeam2() : matchInput.getTeam1();
        }
        match.setTeam1(teamBatting1st);
        match.setTeam2(teamBatting2nd);
        match.setTossWinner(matchInput.getTossWinner());
        match.setTossDecision(matchInput.getTossDecision());
        match.setWinningTeam(matchInput.getWinningTeam());
        match.setWonBy(matchInput.getWonBy());
        match.setMargin(matchInput.getMargin());
        match.setPlayerOfMatch(matchInput.getPlayerOfMatch());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());
        return match;
    }

}
