import React from 'react';
import logo from './honest.png';
import './App.css';
import FactChecker from "./Components/FactChecker/checker";


function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <FactChecker /> 
      </header>
    </div>
  );
}

export default App;
