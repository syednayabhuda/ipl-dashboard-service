import React, { useEffect, useState } from 'react'
import { MatchDetailCard } from '../MatchDetailCard'
import { useParams, Link } from 'react-router-dom'
import { YearSelector } from '../YearSelector'
import './MatchPage.scss'

export const MatchPage = () => {

    const [matches, setMatches] = useState([])
    const { teamName, year } = useParams()

    useEffect(() => {
        const fetchMatchesForTeamInYear = async () => {
            const response = await fetch(`${process.env.REACT_APP_API_BASE_URL}/team/${teamName}/matches?year=${year}`)
            const data = await response.json()
            setMatches(data)
        }

        fetchMatchesForTeamInYear()

    }, [teamName, year])

    return (
        <div className='MatchPage'>
            <div className='year-selector'>
                <h3>Select year</h3>
                <YearSelector teamName={teamName} />
            </div>
            <div>
                <h1 className='match-page-header'>{teamName} matches in {year}</h1>
                {matches.length > 0 ?
                    matches.map(match => <MatchDetailCard key={match.id} teamName={teamName} match={match} />)
                    : <h1 className='no-matches'>No Matches Found</h1>}
            </div>
            <div className='go-to-home home-from-matchPage'>
                <Link to={'/'}>Go to home&#8599;</Link>
            </div>
        </div>
    )
}