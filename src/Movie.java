public class Movie {
    private String title;
    private String director;
    private int yearCreated;
    private boolean isInColor;
    private int lengthInMinutes;
    private String genre;

    public Movie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre) {
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
    public boolean getIsInColor(){
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

    public void setInColor(boolean inColor) {
        isInColor = inColor;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
