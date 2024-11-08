package data_souce;

import models.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private String fileName;

    public FileHandler() {
        fileName = "Movies.txt";
    }

    public void addToFile(Movie movie) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(movie.getTitle() + ","
                + movie.getDirector() + ","
                + movie.getYearCreated() + ","
                + movie.getIsInColor() + ","
                + movie.getLengthInMinutes() + ","
                + movie.getGenre());
        writer.newLine();
        writer.flush();
    }

    public void updateFile(ArrayList<Movie> movies) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Movie movie : movies) {
            writer.write(movie.getTitle() + "," +
                    movie.getDirector() + "," +
                    movie.getYearCreated() + "," +
                    movie.getIsInColor() + "," +
                    movie.getLengthInMinutes() + "," +
                    movie.getGenre());
            //
            writer.write("\n");
            writer.flush();
        }
    }

    public ArrayList<Movie> getMovieArraylist() {
        try {
            File file = new File(fileName);
            ArrayList<Movie> movieArrayList = new ArrayList<>();

            try (Scanner sc = new Scanner(new File(String.valueOf(file)))) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();

                    String[] attributes = line.split(",");

                    Movie movie = new Movie(
                            attributes[0],
                            attributes[1],
                            Integer.parseInt(attributes[2]),
                            attributes[3],
                            Integer.parseInt(attributes[4]),
                            attributes[5]
                    );
                    movieArrayList.add(movie);
                }
            }

            return movieArrayList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
