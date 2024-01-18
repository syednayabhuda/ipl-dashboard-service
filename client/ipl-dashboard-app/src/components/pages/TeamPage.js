import React, { useEffect, useState } from 'react'
import { useParams, Link } from 'react-router-dom'
import { MatchDetailCard } from '../MatchDetailCard'
import { MatchSmallCard } from '../MatchSmallCard'
import { PieChart } from 'react-minimal-pie-chart'
import './TeamPage.scss'

export const TeamPage = () => {

    const { teamName } = useParams()
    const [team, setTeam] = useState({ matches: [] })

    useEffect(() => {

        const fetchLatestMatches = async () => {
            const response = await fetch(`${process.env.REACT_APP_API_BASE_URL}/team/${teamName}`)
            const data = await response.json()
            setTeam(data)
        }

        fetchLatestMatches()

    }, [teamName])

    if (!team || !team.teamName)
        return <h1>Team Not Found</h1>
    return (
        < div className='TeamPage' >
            <div className='team-name-section'>
                <h1 className='team-name'>{team.teamName}</h1>
            </div>
            <div className='wins-losses-section'>Wins / Losses
                <PieChart
                    data={[
                        { title: 'Losses', value: team.totalWins, color: '#8e1c31' },
                        { title: 'Wins', value: team.totalMatches - team.totalWins, color: '#03793a' }
                    ]} />
            </div>
            <div className='match-detail-section'>
                <h3>Latest Matches</h3>
                <MatchDetailCard teamName={team.teamName} match={team.matches[0]} />
            </div>
            {team.matches?.slice(1).map(match => <MatchSmallCard key={match.id} teamName={team.teamName} match={match} />)}
            <div className='more-link'>
                <Link to={`/team/${teamName}/matches/${process.env.REACT_APP_DATA_END_YEAR}`}>More&#8599;</Link>
            </div>
            <div className='go-to-home home-from-teamPage'>
                <Link to={'/'}>Go to home&#8599;</Link>
            </div>
        </div >
    )
}
