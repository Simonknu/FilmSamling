package models;


import data_souce.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class MovieList {
    private ArrayList<Movie> movieArrayList;
    private final FileHandler fileHandler;
    private Movie selectedMovie;


    public ArrayList<Movie> getMovieArrayList() {
        return movieArrayList;
    }

    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    public MovieList() {
        this.movieArrayList = new ArrayList<>();
        fileHandler = new FileHandler();
        movieArrayList = fileHandler.getMovieArraylist();
    }

    public void addMovie(String title, String director, int yearCreated, String isInColor, int lengthInMinutes, String genre) throws IOException {
        Movie movie = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        movieArrayList.add(movie);
        fileHandler.addToFile(movie);

    }

    public String showMovieList() {
        String result = "";
        for (Movie i : movieArrayList) {
            result += i.getTitle() + "\n";
        }
        return result;
    }
    public String sortedMovieList(int sorting){
        String result = "";
          switch (sorting){
             case 1 ->  result = showMovieList();
             case 2 -> {
                 for( Movie i : movieArrayList){
                     result += i.getTitle() + " (" + i.getDirector() + ")" + "\n";
                 }
             }
             case 3 -> {
                 for (Movie i : movieArrayList) {
                     result += i.getTitle() + " (" + i.getYearCreated() + ")" + "\n";
                 }
             }
             case 4 -> {
                 for (Movie i : movieArrayList) {
                     result += i.getTitle() + " (" + i.getLengthInMinutes() + ")" + "\n";
                 }
             }
                 case 5 -> {
                     for (Movie i : movieArrayList) {
                         result += i.getTitle() + " (" + i.getGenre() + ")" + "\n";
                     }
                 }
                 default -> result = "";
             }
        return result;
    }

    public void updateMovieInformation() throws IOException {
        fileHandler.updateFile(movieArrayList);

    }

    public void deleteMovie() throws IOException {
        movieArrayList.remove(selectedMovie);
        fileHandler.updateFile(movieArrayList);
    }


    // check if movie exist and then selects it for different actions like editing or deleting
    public boolean checkIfMovieExist(String movieTitle) {
        for (Movie i : movieArrayList) {
            if (i.getTitle().contains(movieTitle)) {
                selectedMovie = i;
                return true;
            }

        }
        return false;

    }

    public String sortedMovies(int sorting) {
        StringBuilder result = new StringBuilder("");
        switch (sorting) {
            case 1 -> {
                result.append("movies sorted by title: ");
                movieArrayList.sort(Comparator.comparing(Movie::getTitle));
            }
            case 2 -> {
                result.append("Movies sorted by director: ");
                movieArrayList.sort(Comparator.comparing(Movie::getDirector));
            }
            case 3 -> {
                result.append("movies sorted by year of creation: ");
                movieArrayList.sort(Comparator.comparing(Movie::getYearCreated));
            }
            case 4 -> {
                result.append("movies sorted by length: ");
                movieArrayList.sort(Comparator.comparing(Movie::getLengthInMinutes));
            }
            case 5 -> {
                result.append("movies sorted by Genre: ");
                movieArrayList.sort(Comparator.comparing(Movie::getGenre));
            }
            default -> result.append("that is not an option");
        }
        result.append("\n" + sortedMovieList(sorting));
        String finalResult = String.valueOf(result);
        return finalResult;
    }

    //---------------------------------------setters------------------------------------------------
    public void setTitle(String title) {
        selectedMovie.setTitle(title);
    }

    public void setDirector(String director) {
        selectedMovie.setDirector(director);
    }

    public void setYearOfCreation(int year) {
        selectedMovie.setYearCreated(year);
    }

    public void setLength(int length) {
        selectedMovie.setLengthInMinutes(length);
    }

    public void setIsIsColor(String color) {
        selectedMovie.setInColor(color);

    }

    public void setGenre(String genre) {
        selectedMovie.setGenre(genre);
    }

}



