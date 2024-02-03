// App.js
import React from "react";
import "./App.css"; // Ensure this file doesn't conflict with Tailwind classes

function App() {
  return (
    <div className="App font-sans bg-purple-100 min-h-screen flex flex-col">
      <Header />
      <Search />
    </div>
  );
}

function Header() {
  return (
    <div className="header flex flex-col sm:flex-row justify-between items-center bg-purple-600 p-4 text-white">
      <h1 className="text-3xl font-bold mb-4 sm:mb-0">Your Site Name</h1>
      <div className="tabs flex gap-4">
        <div className="tab font-semibold text-lg cursor-pointer px-4 py-2 bg-purple-800 rounded-lg shadow">
          Profile Search
        </div>
        <div className="tab font-semibold text-lg cursor-pointer px-4 py-2 hover:bg-purple-700 rounded-lg shadow transition-colors duration-300">
          About Us
        </div>
      </div>
    </div>
  );
}

function Search() {
  return (
    <div className="search-section mx-auto mt-12 mb-8 p-6 max-w-6xl bg-white rounded-lg shadow-xl">
      <div className="text-center mb-6">
        <h2 className="text-4xl font-bold text-purple-800">Profile Search</h2>
        <p className="text-xl text-purple-600"></p>
      </div>
      <div className="search-bar flex justify-center">
        <input
          type="text"
          placeholder="Search profiles..."
          className="w-3/4 p-3 border border-purple-300 rounded-l-lg focus:outline-none"
        />
        <button className="bg-purple-500 hover:bg-purple-600 text-white font-bold py-2 px-8 rounded-r-lg shadow-lg transition-colors duration-300">
          Search
        </button>
      </div>
    </div>
  );
}

export default App;
