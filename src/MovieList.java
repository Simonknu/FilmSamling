import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MovieList {
    private ArrayList<Movie> movieArrayList;
    private String name;
    static Scanner scanner = new Scanner(System.in);


    public MovieList(String name) {
        this.name = name;
        this.movieArrayList = new ArrayList<Movie>();
    }

    public void createMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre) {
        Movie movie = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        movieArrayList.add(movie);
    }

    public void showMovieList() {
        for (Movie i : movieArrayList) {
            System.out.println(i.getTitle());
        }
    }

    public void showMovie(String name) {
        name.toLowerCase(Locale.ROOT);
        int numOfMovies = 0;
        Movie onlyMovie = null;
        for (Movie i : movieArrayList) {
            if (i.getTitle().contains(name)) {
                onlyMovie = i;
                numOfMovies++;
                System.out.println(i.getTitle());
            }
        }
        if (numOfMovies == 0) {
            System.out.println(name + " We couldn´t find any movies that contain " + name);
        } else if (numOfMovies == 1) {
            System.out.println("Title: " + onlyMovie.getTitle());
            System.out.println("Director: " + onlyMovie.getDirector());
            System.out.println("Year of Creation: " + onlyMovie.getYearCreated());
            System.out.println(onlyMovie.getIsInColor() ? "It is in color" : "It is not in color");
            System.out.println("Length in minutes: " + onlyMovie.getLengthInMinutes());
            System.out.println("Genre: " + onlyMovie.getGenre());
        } else {
            System.out.println("This are all the movies that contain " + name +
                    "Which one do you want to choose");
        }


    }

    public void editMovie(String) {
        System.out.println("What would you like to edit? \n1. Title \n2. Director \n3. Year of creation \n4. Is in color \n5. Length in minutes \n6. Genre \nChoose a number of the list");
        scanner.nextLine(); // make sure the scanner works properly
        int input = 0;
        while (true){
        if (scanner.hasNextInt()){
            input = scanner.nextInt();
            break;
        } else {
            System.out.println("choose one of the numbers in the menu");
        }
        }
        switch (input) {
            case 1 -> {
                System.out.println("Write the new title you want to give the movie: ");
                String title = scanner.nextLine();
                movie
            }
            case 2 ->
            case 3 ->
            case 4 ->
            case 5 ->
        }

    }

}

