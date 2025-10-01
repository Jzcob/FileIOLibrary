

public abstract class MediaItem {
    protected String id;
    protected String title;
    protected int year;

    public MediaItem(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public void summary() {}
}
