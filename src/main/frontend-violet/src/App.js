import React from "react";
import { BrowserRouter as Router, Route, Link, Routes } from "react-router-dom";
import "./App.css";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Search />} />
        <Route path="/about" element={<AboutUs />} />
      </Routes>
    </Router>
  );
}

function Header() {
  return (
    <div className="header flex justify-between items-center bg-purple-600 p-4 text-white">
      <Link
        to="/"
        className="tab font-semibold text-lg cursor-pointer px-4 py-2 hover:bg-purple-700 rounded-lg shadow transition-colors duration-300"
      >
        Profile Search
      </Link>
      <Link
        to="/about"
        className="tab font-semibold text-lg cursor-pointer px-4 py-2 hover:bg-purple-700 rounded-lg shadow transition-colors duration-300"
      >
        About Us
      </Link>
    </div>
  );
}

function Search() {
  // Added useState to handle the input field
  const [searchInput, setSearchInput] = React.useState("");

  // This will handle the state for showing the mock results
  const [showResults, setShowResults] = React.useState(false);

  return (
    <>
      <Header />
      <div className="search-section mx-auto mt-12 mb-8 p-6 max-w-6xl bg-white rounded-lg shadow-xl">
        <div className="text-center mb-6">
          <h2 className="text-4xl font-bold text-purple-800">Profile Search</h2>
        </div>
        <div className="search-bar flex justify-center">
          <input
            type="text"
            placeholder="Search profiles..."
            className="w-3/4 p-3 border border-purple-300 rounded-l-lg focus:outline-none"
            value={searchInput}
            onChange={(e) => setSearchInput(e.target.value)}
          />
          <button
            className="bg-purple-500 hover:bg-purple-600 text-white font-bold py-2 px-8 rounded-r-lg shadow-lg transition-colors duration-300"
            onClick={() => setShowResults(true)}
          >
            Search
          </button>
        </div>
        {showResults && <ProfileResults searchInput={searchInput} />}
      </div>
    </>
  );
}

function ProfileResults({ searchInput }) {
  // Static data for display purposes
  const profiles = [
    { name: "Reddit", username: "Not Taken" },
    { name: "Twitter (X)", username: "Not Taken" },
    { name: "LinkedIn", username: "Not Taken" },
    { name: "Facebook (Meta) ", username: "Not Taken" },
    // Add more profiles as needed
  ];

  return (
    <div className="profile-results mx-auto mt-4 mb-8 p-6 max-w-6xl bg-white rounded-lg shadow-xl">
      {profiles.map((profile, index) => (
        <div
          key={index}
          className="flex items-center justify-between p-4 border-b"
        >
          <span className="font-bold">{profile.name}</span>
          <span>{searchInput ? searchInput : profile.username}</span>
        </div>
      ))}
    </div>
  );
}

// Make sure to export your components if they are in separate files
export { Search, AboutUs, Header, ProfileResults };

function AboutUs() {
  return (
    <>
      <div className="header flex justify-between items-center bg-purple-600 p-4 text-white">
        <Link
          to="/"
          className="tab font-semibold text-lg cursor-pointer px-4 py-2 bg-purple-800 rounded-lg shadow"
        >
          Profile Search
        </Link>
        <Link
          to="/about"
          className="tab font-semibold text-lg cursor-pointer px-4 py-2 hover:bg-purple-700 rounded-lg shadow transition-colors duration-300"
        >
          About Us
        </Link>
      </div>
      <div className="about-us mx-auto p-6 max-w-4xl bg-white rounded-lg shadow-xl">
        <h2 className="text-4xl font-bold text-purple-800 mb-6">About Us</h2>
      </div>
    </>
  );
}

export default App;
