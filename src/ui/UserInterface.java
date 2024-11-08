package ui;

import models.Controller;


import java.io.IOException;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.out;

public class UserInterface {
    private Controller controller;
    static Scanner scanner = new Scanner(System.in);
    String input = "";

    public UserInterface() {
        controller = new Controller();
        PrintStream out = System.out;
        ;
    }

    public void startProgram() throws IOException {

        outerLoop:
        while (true) {
            out.print("You can: \n1. Create new movie \n2. Show movie list \n3. Search a movie \n4. Edit a movie \n5. Delete a movie from the list \n6. Sort movies \n7. Exit program \nChose a number \n->");

            String input = scanner.nextLine();
            input.toLowerCase(Locale.ROOT);
            switch (input) {
                case "1" -> createMovie(out);
                case "2" -> showMovieList(out);
                case "3" -> showSpecificMovie(out);
                case "4" -> editMovie(out);
                case "5" -> deleteMovie(out);
                case "6" -> sortMovies(out);
                case "7" -> {
                    out.println("You will exit the program now");
                    break outerLoop;
                }
                default -> out.println("That is not a command, try again");
            }
        }

    }

    public void createMovie(PrintStream out) throws IOException {
        Boolean isInColorBoolean;
        out.println("title of the movie: ");
        String title = scanner.nextLine();
        out.println("Name of the director: ");
        String director = scanner.nextLine();
        int yearCreated = 0;
        while (true) {
            out.println("Year of creation: ");
            try {
                yearCreated = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                out.println("That is not a valid year. Try again.");
            }
        }
        String isInColor = "";
        while (true) {
            out.println("Is it in color? ");
            isInColor = scanner.nextLine();
            if (isInColor.equalsIgnoreCase("yes") || isInColor.equalsIgnoreCase("no")) {

                break;
            } else {
                out.println("You can only write yes or no. Try again");
            }

        }

        int lengthInMinutes = 0;
        while (true) {
            out.println("Length in minutes: ");
            try {
                lengthInMinutes = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                out.println("That is not a valid Length. Try again.");
            }
        }

        out.println("Genre: ");
        String genre = scanner.nextLine();

        controller.createMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        out.println("You have created a new models.Movie :D");

    }

    public void showMovieList(PrintStream out) {
        out.println("List of movies:");
        out.println(controller.showMovieList());

    }

    public void showSpecificMovie(PrintStream out) {
        out.println("Which movie do you want to search?");
        if (controller.checkIfMovieExist(input = scanner.nextLine())) {
            out.println(controller.movieToString(input));
        } else {
            out.println("Movie not found :(");
        }

    }

    public void editMovie(PrintStream out) throws IOException {
        out.println("Which movie would you like to edit?");
        if (controller.checkIfMovieExist(input = scanner.nextLine())) {
            out.println("Choose one option to edit");
            out.println("1. Title \n2. Director \n3. Year of creation \n4. Length \n5. Is it in color \n6. genre");
            outerLoop:
            while (true) {
                input = scanner.nextLine();
                switch (input) {
                    case "1" -> {
                        out.println("Write the new title: ");
                        controller.setTitle(input = scanner.nextLine());
                        break outerLoop;
                    }

                    case "2" -> {
                        out.println("Write the new director: ");
                        controller.setDirector(input = scanner.nextLine());
                        break outerLoop;

                    }
                    case "3" -> {
                        out.println("Write the new year of creation: ");
                        controller.setYearOfCreation(checkIfInt(scanner, out));
                        break outerLoop;

                    }
                    case "4" -> {
                        out.println("Write the new length: ");
                        controller.setLength(checkIfInt(scanner, out));
                        break outerLoop;

                    }
                    case "5" -> {
                        out.println("Write the new state of color (yes or no): ");
                        controller.setIsInColor(input = scanner.nextLine());
                        break outerLoop;

                    }
                    case "6" -> {
                        out.println("Write the new genre: ");
                        controller.setGenre(input = scanner.nextLine());
                        break outerLoop;

                    }
                    default -> out.println("Choose one of the numbers");
                }
            }
            controller.updateMovieInformation();
        } else {
            out.println("Movie not found");
        }


    }

    public void deleteMovie(PrintStream out) throws IOException {
        out.println("Which movie do you want to delete?");
        if (controller.checkIfMovieExist(input = scanner.nextLine())) {
            out.println("Are you sure you want to delete " + controller.getSelectedMovie().getTitle() + "?");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                controller.deleteMovie();
            }
        } else {
            out.println("Movie was not found :(");
        }

    }

    // check if the input is actually an integer
    public int checkIfInt(Scanner num, PrintStream out) {

        try {
            return Integer.parseInt(num.nextLine());

        } catch (NumberFormatException e) {
            out.println("That is not a valid number. Try again.");
            return checkIfInt(scanner, out);
        }

    }

    public void sortMovies(PrintStream out) {
        System.out.println("Choose sorting option:");
        System.out.println("1. Title");
        System.out.println("2. Director");
        System.out.println("3. Year of Creation");
        System.out.println("4. Length");
        System.out.println("5. Genre");

        int choice = checkIfInt(scanner, out);
        out.println(controller.sortedMovies(choice));


    }
}





