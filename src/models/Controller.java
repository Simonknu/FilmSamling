package models;

import java.io.IOException;

public class Controller {
    private MovieList movieList;


    public Controller(){
        movieList = new MovieList();
    }

    public Movie getSelectedMovie(){
        return movieList.getSelectedMovie();
    }

    public void setTitle(String newTitle){
        movieList.setTitle(newTitle);
    }
    public void setDirector(String director){
        movieList.setDirector(director);
    }
    public void setYearOfCreation(int newYear){
        movieList.setYearOfCreation(newYear);
    }
    public void setLength(int length){
        movieList.setLength(length);
    }
    public void setIsInColor(String color){
        movieList.setIsIsColor(color);
    }
    public void setGenre(String genre){
        movieList.setGenre(genre);
    }



    public void createMovie(String title, String director, int yearCreated, String isInColor, int lengthInMinutes, String genre) throws IOException {
        movieList.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
    }
    public String showMovieList(){
        return movieList.showMovieList();
    }

    public boolean checkIfMovieExist(String movieName){
        return movieList.checkIfMovieExist(movieName);
    }


    public void updateMovieInformation() throws IOException {
        movieList.updateMovieInformation();
    }
    public void deleteMovie() throws IOException {
        movieList.deleteMovie();

    }

    public String movieToString(String movieName){
        Movie currentMovie = null;
        for (Movie i : movieList.getMovieArrayList()){
            if (i.getTitle().contains(movieName)){
                currentMovie = i;
            }
        }
        return currentMovie.toString();
    }

    public String sortedMovies(int sorting){

        return movieList.sortedMovies(sorting);
    }


}
