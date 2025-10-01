import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MediaParser mediaParser = new MediaParser();

        char y = 'y';
        while (y == 'y') {

            System.out.println("Here is the what you can do!");
            System.out.println("1) List all media items");
            System.out.println("2) Add a new media item (Book, Movie, Album");
            System.out.println("3) Save the catalog to CSV");
            System.out.println("4) Export catalog to a binary file");
            System.out.println("5) Remove a media item by ID");
            System.out.println("6) Exit");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    try {
                        mediaParser.listMediaItems();
                    } catch (Exception e) {
                        System.out.println("Error listing media items: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Which type of media would you like to add? (Book, Movie, Album)");
                    String mediaType = scanner.nextLine();
                    System.out.println("Enter title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter author:");
                    String author = scanner.nextLine();
                    System.out.println("Enter year:");
                    int year = scanner.nextInt();
                    System.out.println("Enter page/track count or the movie length:");
                    int count = scanner.nextInt();
                    if (mediaType.equalsIgnoreCase("Book")) {
                        Book book = new Book(title, author, year, count);
                        mediaParser.addMediaItem(book);
                        book.summary();
                        System.out.println("Book added successfully.\n\n\n\n");
                    } else if (mediaType.equalsIgnoreCase("Movie")) {
                        System.out.println("Only adding books is implemented so far.");
                    } else if (mediaType.equalsIgnoreCase("Album")) {
                        System.out.println("Only adding books is implemented so far.");
                    } else {
                        System.out.println("Invalid media type.");
                    }
                    break;
                case 3:
                    System.out.println("Saving the catalog to CSV is not yet implemented.");
                    break;
                case 4:
                    System.out.println("Exporting catalog to a binary file is not yet implemented.");
                    break;
                case 5:
                    System.out.println("Removing a media item by ID is not yet implemented.");
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    y = 'n';
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}