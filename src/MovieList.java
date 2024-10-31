import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MovieList {
    private ArrayList<Movie> movieArrayList;
    static Scanner scanner = new Scanner(System.in);


    public ArrayList<Movie> getMovieArrayList() {
        return movieArrayList;
    }

    public MovieList() {
        this.movieArrayList = new ArrayList<>();
    }

    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre) {
        Movie movie = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        movieArrayList.add(movie);
    }

    public void showMovieList() {
        for (Movie i : movieArrayList) {
            System.out.println(i.getTitle());
        }
    }

    public void showMovie(String name) {
        name = name.toLowerCase(Locale.ROOT);
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
        } else if (numOfMovies > 1) {
            System.out.println("This are all the movies that contain " + name +
                    "Which one do you want to choose");
            String input = scanner.nextLine();
            for (Movie i : movieArrayList) {
                if (i.getTitle().contains(input)) {
                    onlyMovie = i;

                }
            }
        }


            System.out.println("Title: " + onlyMovie.getTitle());
            System.out.println("Director: " + onlyMovie.getDirector());
            System.out.println("Year of Creation: " + onlyMovie.getYearCreated());
            System.out.println(onlyMovie.getIsInColor() ? "It is in color" : "It is not in color");
            System.out.println("Length in minutes: " + onlyMovie.getLengthInMinutes());
            System.out.println("Genre: " + onlyMovie.getGenre());



    }

    public void editMovie() {
        System.out.println("Which movie would you like to edit?");
        String movieName = scanner.nextLine();
        Movie chosenMovie = null;
        int numOfMovies = 0;
        for (Movie i : movieArrayList) {
            if (i.getTitle().contains(movieName)) {
                chosenMovie = i;
                numOfMovies++;
                System.out.println(i.getTitle());
            }
        }
        if (numOfMovies == 0) {
            System.out.println("There is no movies that contain " + movieName);
        } else if (numOfMovies > 1) {
            System.out.println("These are all the movies that contain " + movieName + "\nWhich one do you want to edit?");
            String input = scanner.nextLine();
            for (Movie i : movieArrayList) {
                if (i.getTitle().contains(input)) {
                    i = chosenMovie;
                }
            }
        }

        System.out.println("What would you like to edit? \n1. Title \n2. Director \n3. Year of creation \n4. Is in color \n5. Length in minutes \n6. Genre \nChoose a number of the list");

        int input = 0;
        while (true) {

            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                break;
            } else {
                System.out.println("choose one of the numbers in the menu");
            }
        }
        switch (input) {
            case 1 -> {
                System.out.println("Write the new title you want to give the movie: ");
                scanner.nextLine();
                String title = scanner.nextLine();
                chosenMovie.setTitle(title);
            }
            case 2 -> {
                System.out.println("Write the new director you want to give the movie: ");
                scanner.nextLine();
                String director = scanner.nextLine();
                chosenMovie.setDirector(director);
            }
            case 3 -> {

                int yearCreated = 0;
                while (true) {
                    System.out.println("Write the new year of creation you want to give the movie: ");
                    scanner.nextLine();
                    try {
                        yearCreated = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("That is not a valid year. Try again.");
                    }
                }
                chosenMovie.setYearCreated(yearCreated);
            }
            case 4 -> {
                System.out.println("Write the new state of color you want to give the movie: ");
                scanner.nextLine();
                String isInColor = scanner.nextLine();
                switch (isInColor) {
                    case "yes", "ye", "y" -> chosenMovie.setInColor(true);
                    default -> chosenMovie.setInColor(false);
                }
                ;
            }
            case 5 -> {
                int lengthInMinutes = 0;
                while (true) {
                    System.out.println("Write the new length in minutes you want to give the movie: ");
                    try {
                        scanner.nextLine();
                        lengthInMinutes = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("That is not a valid Length. Try again.");
                    }
                }
                chosenMovie.setLengthInMinutes(lengthInMinutes);
            }
            case 6 -> {
                System.out.println("Write the new genre you want to give the movie: ");
                scanner.nextLine();
                String genre = scanner.nextLine();
                chosenMovie.setGenre(genre);

            }
        }
        System.out.println("You have edited the film :D");


    }
}



