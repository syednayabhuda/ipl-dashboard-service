import React from 'react'
import { Link } from 'react-router-dom'

export const MatchSmallCard = ({ teamName, match }) => {

    const otherTeam = teamName === match.team1 ? match.team2 : match.team1
    const didWin = teamName === match.winningTeam

    return (
        <div className={didWin ? 'won-card' : 'lost-card'} style={{ padding: '3%', marginBottom: '5vh' }}>
            <span>vs</span>
            <h1>
                <Link to={`/team/${otherTeam}`}>{otherTeam}</Link>
            </h1>
            <p style={{ marginTop: '2vh' }}>{match.winningTeam} won by {match.margin} {match.wonBy}</p>
        </div >
    )
}
