# Moviecvp App
## Overview
This is a Spring Boot web application that allows users to search for movies, view details, and manage a list of their favorite films. The app uses Thymeleaf for server-side rendering and leverages the TMDb (The Movie Database) API to fetch movie data.

## Features
- **Movie Search:** Search for any movie by title.
- **Trending Movies:** View a list of the most popular trending movies on the homepage.
- **Movie Details:** Click on a movie to see more information, including its poster, overview, release date, and rating.
- **Favorites:** Add or remove movies from a personal favorites list.
- **Persistence:** Your favorite movies are saved and will persist even after restarting the application.

## Getting Started
### Prerequisites
- Java 17 or higher
- Maven
- A TMDb API key

### Installation
1. Clone the repository:
    ```Bash
    git clone [your-repository-url]
    cd movie-catalogue
    ```
2. Add your TMDb API key:
    Open the ``src/main/resources/application.properties`` file and add your API key.
    ```Properties
    tmdb.api.key=[your-api-key]
    ```
3. Run the application:
    ```Bash
    mvn spring-boot:run
    ```
    The application will start on http://localhost:8080.

## Screenshots
### Homepage
The homepage displays a list of trending movies and includes a search bar to find specific titles.
![Homepage screenshot](/screenshots/movies-list.png)
### Movie Details Page
Clicking a movie from the list takes you to a details page with more information and the option to add or remove it from your favorites.
![Detail page screenshot](/screenshots/movie-details.png)

### Favorites List
This page shows all the movies you have added to your favorites.
![Favorist list view screenshot](/screenshots/favorites.png)

### Search Results
Using the search field you can see a list of movies for a specific title.
![Search results screenshot](/screenshots/search.png)
