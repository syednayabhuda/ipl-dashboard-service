import './App.scss';
import { HashRouter as Router, Route, Routes } from 'react-router-dom';
import { TeamPage } from './components/pages/TeamPage';
import { MatchPage } from './components/pages/MatchPage';
import { HomePage } from './components/pages/HomePage';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path='/' element={<HomePage />} />
          <Route path='/teams' element={<HomePage />} />
          <Route path='/team/:teamName' element={<TeamPage />} />
          <Route path='/team/:teamName/matches/:year' element={<MatchPage />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
