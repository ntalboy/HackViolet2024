// App.js
import React from "react";
import "./App.css";

function App() {
  return (
    <div className="App">
      <Header />
      <Search />
    </div>
  );
}

function Header() {
  return (
    <div className="header">
      <div className="tab selected">Profile Search</div>
      <div className="tab">About Us</div>
    </div>
  );
}

function Search() {
  return (
    <div className="search-section">
      <h1>Profile Search</h1>
      <div className="search-bar">
        <input type="text" placeholder="Search profiles..." />
        <button>Search</button>
      </div>
    </div>
  );
}

export default App;
