import React from 'react';
import { BrowserRouter } from 'react-router-dom'
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import 'font-awesome/css/font-awesome.min.css'


import Header from './templates/Header';
import Main from './templates/Main';

//Hooks react app
function App() {
  return (
    <BrowserRouter>
      <div className="d-flex flex-column ">
        <Header />
        <Main />
      </div>
    </BrowserRouter>
  );
}

export default App;
