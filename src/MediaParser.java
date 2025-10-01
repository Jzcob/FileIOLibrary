import java.io.*;

public class MediaParser {
    private String csvfile = "catalog.csv";
    final File file = new File(csvfile);
    private String binFile = "catalog.bin";
    final File bin = new File(binFile);
    private String id;


    public MediaParser() {
        // create the files if they don't exist
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        try {
            if (bin.createNewFile()) {
                System.out.println("File created: " + bin.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    public String generateID(MediaItem mediaItem) {
        String prefix = "";
        if (mediaItem instanceof Book) {
            prefix = "BK-";
        }
        int maxId = 0;
        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = in.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length > 0 && parts[0].startsWith(prefix)) {
                        String[] idParts = parts[0].split("-");
                        if (idParts.length == 2) {
                            try {
                                int num = Integer.parseInt(idParts[1]);
                                if (num > maxId) maxId = num;
                            } catch (NumberFormatException ignored) {}
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prefix + (maxId + 1);
    }

    public String checkID(String proposedID) {
        if (!file.exists()) {
            return proposedID;
        } else {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = in.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length > 0 && parts[0].equals(proposedID)) {
                        int number = Integer.parseInt(parts[0].split("-")[1]);
                        number++;
                        proposedID = parts[0].split("-")[0] + "-" + number;
                        return checkID(proposedID);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return proposedID;
    }

    public void addMediaItem(MediaItem mediaItem) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file, true))) {
            if (mediaItem instanceof Book) {
                Book book = (Book) mediaItem;
                out.write(String.format("%s,%s,%s,%d,%d%n", generateID(book) , book.title, book.getAuthor(), mediaItem.year, book.getPageCount()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveCatalog() {

    }

    public void exportToBinary() {

    }

    public void listMediaItems() throws FileNotFoundException {
        BufferedReader in = new BufferedReader(new FileReader(csvfile));
        String line;
        try {
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
