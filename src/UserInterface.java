import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private Controller controller;
    static Scanner scanner = new Scanner(System.in);

   public UserInterface(){
       controller = new Controller();
   }

   public void startProgram() {

        outerLoop:
        while (true) {
            System.out.println("You can: \nCreate new movie \nShow movie lis \nSearch a movie \nEdit a movie \nExit program");

            String input = scanner.nextLine();
            input.toLowerCase(Locale.ROOT);
            switch (input){
                case "new movie", "new", "create", "add", "add movie" ->  createMovie();


                case "movie list", "show movies", "list", "movies", "show list", "show movie list" -> {
                    controller.showMovieList();
                }
                case "search movie", "search" -> {
                    System.out.println("What movie do you want to see?");
                    controller.showMovie(input = scanner.nextLine());
                }
                case "edit", "edit movie" -> {
                    controller.editMovie();
                }
                case "exit", "exi program", "exit the program" -> {
                    System.out.println("You will exi the program now");
                    break outerLoop;
                }
                default -> System.out.println("That is not a command, try agian");
            }
        }

    }
    public void createMovie(){
        Boolean isInColorBoolean;
        System.out.println("title of the movie: ");
        String title = scanner.nextLine();
        System.out.println("Name of the director: ");
        String director = scanner.nextLine();
        int yearCreated = 0;
        while (true) {
            System.out.println("Year of creation: ");

            if (scanner.hasNextInt()) {
                yearCreated = scanner.nextInt();
                break;
            } else {
                System.out.println("That is not a year. Try again");
                scanner.nextLine();
            }
            scanner.nextLine();
        }
        System.out.println("Is it in color? ");
        scanner.nextLine();
        String isInColor = scanner.nextLine();
        isInColorBoolean = switch (isInColor){
            case "yes", "ye", "y" -> true;
            default -> false;
        };
        System.out.println("Length in minutes: ");
        int lengthInMinutes = scanner.nextInt();
        System.out.println("Genre: ");
        scanner.nextLine();
        String genre = scanner.nextLine();

        controller.createMovie(title, director, yearCreated, isInColorBoolean, lengthInMinutes, genre);
        System.out.println("You have created a new Movie :D");

    }


}

