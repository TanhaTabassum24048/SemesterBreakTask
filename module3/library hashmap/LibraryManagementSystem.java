import java.util.*;

public class LibraryManagementSystem {
    static class Book {
        private String title, author, genre;
        private int year;

        public Book(String title, String author, String genre, int year) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.year = year;
        }
       
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getGenre() { return genre; }
        public int getYear() { return year; }

        public String display() {
            return title + " | " + author + " | " + genre + " | " + year;
        }
    }
    private static boolean isValidText(String text) {
        return text != null && !text.trim().isEmpty();
    }

    private static boolean isValidYear(int year) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return year >= 1000 && year <= currentYear;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Book> books = new HashMap<>();

        while (true) 
        {
            System.out.println("\n1.Add Book");
            System.out.println("2.View All");
            System.out.println("3.Search");
            System.out.println("4.Remove");
            System.out.println("5.Sorted View");
            System.out.println("6.Exit");
            System.out.print("Choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Genre: ");
                    String genre = sc.nextLine();

                    System.out.print("Year: ");
                    int year = sc.nextInt();

                    if (isValidText(title) && isValidText(author) && isValidYear(year)) {
                        books.put(isbn, new Book(title, author, genre, year));
                        System.out.println("Book added!");
                    } else {
                        System.out.println("Invalid input!");
                    }
                    break;
                case 2: 
                    for (Map.Entry<String, Book> entry : books.entrySet()) {
                        System.out.println("ISBN: " + entry.getKey() +
                                " | " + entry.getValue().display());
                    }
                    break;
                case 3:
                    System.out.print("Enter title/author: ");
                    String search = sc.nextLine();

                    for (Book b : books.values()) {
                        if (b.getTitle().equalsIgnoreCase(search) ||
                            b.getAuthor().equalsIgnoreCase(search)) {
                            System.out.println(b.display());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter ISBN: ");
                    String key = sc.nextLine();

                    if (books.remove(key) != null)
                        System.out.println("Removed!");
                    else
                        System.out.println("Not found!");
                    break;
                case 5:
                    TreeMap<String, Book> sorted = new TreeMap<>(books);

                    for (Map.Entry<String, Book> entry : sorted.entrySet()) {
                        System.out.println("ISBN: " + entry.getKey() +
                                " | " + entry.getValue().display());
                    }
                    break;

                case 6:
                    System.out.println("Exit...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}