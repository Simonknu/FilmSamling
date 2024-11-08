package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieListTest {

    @Test
    public void testGetMovieArrayList() {
        // Arrange
        MovieList movieList = new MovieList();

        // Act
        ArrayList<Movie> movies = movieList.getMovieArrayList();

        // Assert
        assertNotNull(movies, "movieArrayList should be initialized and not null.");
        assertEquals(0, movies.size(), "movieArrayList should be empty initially.");
    }

    @Test
    public void testAddMovie() {
        // Arrange
        MovieList movieList = new MovieList();
        String title = "Inception";
        String director = "Christopher Nolan";
        int year = 2010;
        boolean isInColor = true;
        int length = 148;
        String genre = "Sci-Fi";

        // Act
        movieList.addMovie(title, director, year, isInColor, length, genre);
        ArrayList<Movie> movies = movieList.getMovieArrayList();

        // Assert
        assertEquals(1, movies.size(), "movieArrayList should contain 1 movie.");

        Movie addedMovie = movies.get(0);
        assertEquals(title, addedMovie.getTitle());
        assertEquals(director, addedMovie.getDirector());
        assertEquals(year, addedMovie.getYearCreated());
        assertEquals(isInColor, addedMovie.getIsInColor());
        assertEquals(length, addedMovie.getLengthInMinutes());
        assertEquals(genre, addedMovie.getGenre());
    }

    @Test
    void showMovieList() {
    }

    @Test
    void showMovie() {
    }

    @Test
    void editMovie() {
    }
}