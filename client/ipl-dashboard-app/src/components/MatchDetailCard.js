import React from 'react'
import { Link } from 'react-router-dom'
import './MatchDetailCard.scss'

export const MatchDetailCard = ({ teamName, match }) => {

    const otherTeam = teamName === match.team1 ? match.team2 : match.team1
    const didWin = teamName === match.winningTeam

    return (
        <div className={didWin ? 'MatchDetailCard won-card' : 'MatchDetailCard lost-card'}>
            <div>
                <span>vs</span>
                <h1><Link to={`/team/${otherTeam}`}>{otherTeam}</Link></h1>
                <h3 className='match-date'>{match.date}</h3>
                <h2 className='match-venue'>at {match.venue}</h2>
                <h3 className='match-result'>{match.winningTeam} won by {match.margin} {match.wonBy}</h3>
            </div>
            <div className='additional-details'>
                <h3>First Innings</h3>
                <p>{match.team1}</p>
                <h3>Second Innings</h3>
                <p>{match.team2}</p>
                <h3>Player of the match</h3>
                <p>{match.playerOfMatch}</p>
                <h3>Umpires</h3>
                <p>{match.umpire1}, {match.umpire2}</p>
            </div>
        </div>
    )
}
