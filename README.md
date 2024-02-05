## Inspiration
Our project was inspired by the significant impact digital footprints have on our lives. Our goal is to empower individuals to cultivate a positive online presence, advocating for a more inclusive and respectful digital community by highlighting the importance of self-awareness and accountability in digital interactions.

## What it does
Our project examines users' social media profiles, identifying potential issues like sexism, bias, and discrimination through historical content analysis. It utilizes web scraping tools to scan through a user's comments and posts on social media platforms. This approach allows us to review the content of what users have said, helping them understand how their words or actions might be perceived by others.

## How we built it
We built our project with Spring Boot for the backend and React.js for the frontend, using OpenAI's API to analyze social media content. We designed a clean and user-friendly interface with Tailwind CSS, and our web scrapers collected data from social media platforms to spot potential issues in users' posts.

## Challenges
We faced hurdles with web scraping authorization while trying to retrieve data from certain social media platforms. Moreover, the limited capabilities of the free tier in some platforms' APIs posed challenges. Additionally, we grappled with issues related to Google Cloud rate limiting during the deployment of our website.

## What we learned
Our journey included acquiring skills in Google Cloud deployment and Java REST API programming. Furthermore, this project provided an opportunity to refine our front-end programming abilities.

## Installation and running locally
Clone the repository
```console
git clone https://github.com/ntalboy/HackViolet2024.git
```
Build the project
```console
./gradlew build
```
Set environment variable
```console
set OPENAI_API_KEY=<your api key>
```
Run program (./build/libs/...SNAPSHOT.jar)
```console
java -jar <program name>.jar
```

