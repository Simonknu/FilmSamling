package models;

import java.util.Locale;

public class Movie {
    private String title;
    private String director;
    private int yearCreated;
    private String isInColor;
    private int lengthInMinutes;
    private String genre;

    public Movie(String title, String director, int yearCreated, String isInColor, int lengthInMinutes, String genre) {
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.isInColor = isInColor;
        this.lengthInMinutes= lengthInMinutes;
        this.genre = genre;
    }

    public String getTitle(){
        return title;
    }

    public String getDirector(){
        return director;
    }
    public int getYearCreated(){
        return yearCreated;
    }
    public String getIsInColor(){
        return isInColor;
    }


    public int getLengthInMinutes(){
        return lengthInMinutes;
    }
    public String getGenre(){
        return genre;
    }

    public void setTitle(String newTitle){
        title = newTitle;
    }
    public void setDirector(String newDirector){
        director = newDirector;
    }
    public void setYearCreated(int newYearCreated){
        yearCreated = newYearCreated;
    }
    public void setInColor(String color){
       isInColor = color;
    }
    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Name: " + title + "\n" +
                "Director: " + director + "\n" +
                "Created: " + yearCreated + "\n" +
                "Length: " + lengthInMinutes + " minutes" + "\n" +
                "Is in color: " + getIsInColor() + "\n" +
                "Genre: " + genre + "\n";
    }
}
