import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Route, Link, Routes } from "react-router-dom";
import "./App.css";
import compimg from "./images/computer-picture.png";
import salimg from "./images/salvador.jpg";
import natimg from "./images/nathan.jpg";
import timimg from "./images/timothy.jpg";
import estimg from "./images/esteban.jpg";

function App() {
  useEffect(() => {
    document.title = "Profile Insights";
  }, []);
  return (
    <div className="bg-circular-gradient bg-topo from-violet-300 to-violet-400 min-h-screen">
      <Router>
        <Routes>
          <Route path="/" element={<Search />} />
          <Route path="/about" element={<AboutUs />} />
        </Routes>
      </Router>
    </div>
  );
}

function Header() {
  return (
    <div className="header flex items-center bg-violet-800 p-4 text-white">
      <div className="flex justify-start items-center flex-grow">
        <Link
          to="/"
          className="tab font-urbane text-lg cursor-pointer px-4 py-2 mr-2 bg-violet-500 hover:bg-violet-900 rounded-lg shadow transition-colors duration-300"
        >
          Profile Search
        </Link>
        <Link
          to="/about"
          className="tab font-urbane text-lg cursor-pointer px-4 py-2 ml-2 bg-violet-500 hover:bg-violet-900 rounded-lg shadow transition-colors duration-300"
        >
          About Us
        </Link>
      </div>

      <div
        className="mx-auto absolute left-0 right-0 text-center"
        style={{ width: "max-content" }}
      >
        <h1 className="text-5xl font-urbane font-bold">Profile Insights</h1>
      </div>

      <div className="flex justify-end items-center flex-grow">
        <img src={compimg} alt="Description" className="h-10 w-10" />
      </div>
    </div>
  );
}

function Search() {
  const [searchInput, setSearchInput] = useState("");
  const [profileFlags, setProfileFlags] = useState(null);

  const fetchProfiles = async () => {
    try {
      const response = await fetch(
        `https://profile-insights.uk.r.appspot.com/search?username=${encodeURIComponent(
          searchInput
        )}`
      );
      const data = await response.json();
      setProfileFlags(data);
    } catch (error) {
      console.error("Failed to fetch profile flags:", error);
      setProfileFlags(null);
    }
  };

  return (
    <>
      <Header />
      <div className="search-section mx-auto mt-12 mb-8 p-6 max-w-6xl rounded-lg">
        <div className="search-bar flex justify-center">
          <input
            type="text"
            placeholder="Search profiles..."
            className="w-3/4 p-3 border border-violet-300 rounded-l-lg focus:outline-none"
            value={searchInput}
            onChange={(e) => setSearchInput(e.target.value)}
          />
          <button
            className="bg-violet-800 hover:bg-violet-900 text-white font-bold py-2 px-8 rounded-r-lg shadow-lg transition-colors duration-300"
            onClick={fetchProfiles}
          >
            Search
          </button>
        </div>
        {profileFlags && <ProfileResults profileFlags={profileFlags} />}
      </div>
    </>
  );
}

function FlaggedMessage({ message }) {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <div className="relative inline-block text-left">
      <div>
        <button
          type="button"
          className="text-red-600 hover:text-red-700 flex items-center"
          onClick={() => setIsOpen(!isOpen)}
        >
          Flagged Message
          <span className={`ml-2 ${isOpen ? "transform rotate-180" : ""}`}>
            ▼
          </span>
        </button>
      </div>
      {isOpen && (
        <div className="origin-top-right absolute right-0 mt-2 w-56 rounded-md shadow-lg bg-white ring-1 ring-black ring-opacity-5">
          <div
            className="py-1"
            role="menu"
            aria-orientation="vertical"
            aria-labelledby="options-menu"
          >
            <a
              href="#"
              className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100"
              role="menuitem"
            >
              {message}
            </a>
          </div>
        </div>
      )}
    </div>
  );
}

function ProfileResults({ profileFlags }) {
  const platforms = [
    { name: "Reddit", flag: profileFlags.redditFlag },
    { name: "Twitter", flag: profileFlags.twitterFlag },
    { name: "LinkedIn", flag: profileFlags.linkedinFlag },
    { name: "Facebook", flag: profileFlags.facebookFlag },
  ];

  const renderFlagStatus = (flag, message) => {
    if (flag === "0") {
      return <div className="text-green-600">No issues found</div>;
    } else {
      return <FlaggedMessage message={message} />;
    }
  };

  return (
    <div className="profile-results mx-auto mt-4 mb-8 p-6 max-w-6xl bg-white rounded-lg shadow-xl">
      <h3 className="text-xl font-semibold mb-4">Profile Flags</h3>
      {platforms.map((platform, index) => (
        <div
          key={index}
          className={`p-4 ${
            platform.flag === "0" ? "bg-green-100" : "bg-red-100"
          } rounded-lg mb-3`}
        >
          <h4 className="font-bold">{platform.name}</h4>
          {renderFlagStatus(platform.flag, platform.flag)}
        </div>
      ))}
    </div>
  );
}

export { Search, AboutUs, Header, ProfileResults };

function AboutUs() {
  return (
    <>
      <Header />
      <div className="about-us mx-auto p-6 max-w-4xl bg-white rounded-lg shadow-xl mt-7">
        <h2 className="text-4xl font-bold text-violet-800 mb-6">About Us</h2>
        <p>
          We are a team of VT students dedicated to creating a positive online
          presence for all. Our website aims to review users' social media
          accounts by analyzing historical content to detect potential issues,
          such as sexism, bias, and discrimination. Our objective is not to
          expose individuals but to enhance awareness of one’s digital
          footprint, promoting a more inclusive and respectful online community.
        </p>
      </div>
      <div className="team-profiles mx-auto mt-8 p-6 max-w-4xl bg-white rounded-lg shadow-xl">
        <h3 className="text-3xl font-bold text-violet-800 mb-4">Our Team</h3>
        <div className="grid grid-cols-4 gap-4">
          <div className="text-center">
            <img
              src={estimg}
              alt="Name1"
              className="mx-auto w-24 h-24 rounded-full"
            />
            <p className="mt-2">Esteban</p>
          </div>
          <div className="text-center">
            <img
              src={natimg}
              alt="Name2"
              className="mx-auto w-24 h-24 rounded-full"
            />
            <p className="mt-2">Nathan</p>
          </div>
          <div className="text-center">
            <img
              src={salimg}
              alt="Name3"
              className="mx-auto w-24 h-24 rounded-full"
            />
            <p className="mt-2">Salvador</p>
          </div>
          <div className="text-center">
            <img
              src={timimg}
              alt="Name4"
              className="mx-auto w-24 h-24 rounded-full"
            />
            <p className="mt-2">Timothy</p>
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
