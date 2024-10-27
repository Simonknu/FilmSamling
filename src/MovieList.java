import java.util.ArrayList;
import java.util.Locale;

public class MovieList {
    private ArrayList<Movie> movieArrayList;
    private String name;


    public MovieList(String name){
        this.name = name;
        this.movieArrayList = new ArrayList<Movie>();
    }

    public void createMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre ){
        Movie movie = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        movieArrayList.add(movie);
    }

    public void showMovieList(){
        for (Movie i : movieArrayList){
            System.out.println(i.getTitle());
        }
    }

    public void showMovie(String name) {
        name.toLowerCase(Locale.ROOT);
        int numOfMovies = 0;
        for (Movie i : movieArrayList) {
            if (i.getTitle().contains(name)) {
                numOfMovies++;
                System.out.println(i.getTitle());

                if (numOfMovies == 0) {
                System.out.println(name + " We couldn´t find any movies that contain " + name);
            } else if (numOfMovies == 1) {
                System.out.println("Title: " + i.getTitle());
                System.out.println("Director: " + i.getDirector());
                System.out.println("Year of Creation: " + i.getYearCreated());
                System.out.println(i.getIsInColor() ? "It is in color" : "It is not in color");
                System.out.println("Length in minutes: " + i.getLengthInMinutes());
                System.out.println("Genre: " + i.getGenre());
            } else {
                System.out.println("ke");
            }
        }

    }
        public void editMovie(String name){

        }

    }

