import java.util.Locale;
import java.util.Scanner;

public class Main {
     static MovieList movieList = new MovieList("name");
     static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        outeeLoop:
        while (true) {
            System.out.println("You can: \nCreate new movie \nShow movie list \nExit program");
            String input = scanner.next();
            input.toLowerCase(Locale.ROOT);
            switch (input){
                case "new movie", "new", "create", "add", "add movie" -> createMovie();
                case "movie list", "show movies", "list", "movies", "show list", "show movie list" -> {
                    movieList.showMovieList();
                }
                case "search movie" -> {
                    System.out.println("What movie do you want to see?");
                    movieList.showMovie(input = scanner.next());
                }
                case "exit", "exi program", "exit the program" -> {
                    System.out.println("You will exi the program now");
                    break outeeLoop;
                }
                default -> System.out.println("That is not a command, try agian");
            }
        }

        }
        public static void createMovie(){
            Boolean isInColorBoolean = true;
            System.out.println("title of the movie: ");
            String title = scanner.next();
            System.out.println("Director: ");
            String director = scanner.next();
            int yearCreated = 0;
            while (true) {
                System.out.println("Year of creation: ");

                if (scanner.hasNextInt()) {
                    yearCreated = scanner.nextInt();
                    break;
                } else {
                    System.out.println("That is not a year. Try again");
                    scanner.next();
                }
            }
            System.out.println("Is it in color? ");
            String isInColor = scanner.next();
            switch (isInColor){
                case "yes", "ye", "y" -> {
                    isInColorBoolean = true;
                }
                case "NO", "No", "nO", "N", "n", "no" -> {
                     isInColorBoolean= false;
                }
            }
            System.out.println("Length in minutes: ");
            int lengthInMinutes = scanner.nextInt();
            System.out.println("Genre: ");
            String genre = scanner.next();

            movieList.createMovie(title, director, yearCreated, isInColorBoolean, lengthInMinutes, genre);
            System.out.println("You have created a new Movie :D");

    }


}
