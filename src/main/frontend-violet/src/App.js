// App.js
import React from "react";
import "./App.css"; // Ensure this file doesn't conflict with Tailwind classes

function App() {
  return (
    <div className="App font-sans bg-gray-100 min-h-screen flex flex-col">
      <Header />
      <Search />
    </div>
  );
}

function Header() {
  return (
    <div className="header flex justify-between items-center bg-blue-500 p-4 text-white">
      <div className="tab font-semibold text-lg cursor-pointer px-4 py-2 bg-blue-700 rounded">
        Profile Search
      </div>
      <div className="tab font-semibold text-lg cursor-pointer px-4 py-2 hover:bg-blue-600 rounded transition-colors duration-300">
        About Us
      </div>
    </div>
  );
}

function Search() {
  return (
    <div className="search-section mx-auto my-8 p-6 max-w-xl bg-white rounded shadow">
      <h1 className="text-2xl font-bold mb-4">Profile Search</h1>
      <div className="search-bar flex gap-4">
        <input
          type="text"
          placeholder="Search profiles..."
          className="flex-1 p-2 border border-gray-300 rounded"
        />
        <button className="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded">
          Search
        </button>
      </div>
    </div>
  );
}

export default App;
