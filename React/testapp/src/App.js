import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import TableMenucomp from './tablemenu';
import ButtonAppBar from './dashboard';

class App extends Component {
  render() {
    return (
      <div>
        <ButtonAppBar></ButtonAppBar>
        <TableMenucomp></TableMenucomp>
        
      </div>
    );
  }
}

export default App;
