public class Album extends MediaItem  {
    private String artist;
    private int trackCount;

    public Album(String title, String author, int year, int pageCount) {
        super(title, year);
        this.artist = author;
        this.trackCount = pageCount;
    }

    @Override
    public void summary() {
        System.out.printf("Book: %s by %s, %d, %d pages%n", title, artist, year, trackCount);
    }

    public String getAuthor() {
        return artist;
    }
    public int getPageCount() {
        return trackCount;
    }

    public void setAuthor(String author) {
        this.artist = author;
    }

    public void setPageCount(int pageCount) {
        this.trackCount = pageCount;
    }

}
