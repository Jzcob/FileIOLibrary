public class Movie extends MediaItem  {
    private String director;
    private int runtimeMinutes;

    public Movie(String title, String author, int year, int pageCount) {
        super(title, year);
        this.director = author;
        this.runtimeMinutes = pageCount;
    }

    @Override
    public void summary() {
        System.out.printf("Book: %s by %s, %d, %d pages%n", title, director, year, runtimeMinutes);
    }

    public String getDirector() {
        return director;
    }
    public int getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setRuntimeMinutes(int runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

}
