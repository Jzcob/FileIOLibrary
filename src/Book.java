public class Book extends MediaItem  {
    private String author;
    private int pageCount;

    public Book(String title, String author, int year, int pageCount) {
        super(title, year);
        this.author = author;
        this.pageCount = pageCount;
    }

    @Override
    public void summary() {
        System.out.printf("Book: %s by %s, %d, %d pages%n", title, author, year, pageCount);
    }

    public String getAuthor() {
        return author;
    }
    public int getPageCount() {
        return pageCount;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
