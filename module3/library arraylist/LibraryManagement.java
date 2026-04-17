import java.util.*;

public class LibraryManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("\n1.Add Book");
            System.out.println("2.View All Books");
            System.out.println("3.Search Book");
            System.out.println("4.Check Out Book");
            System.out.println("5.Return Book");
            System.out.println("6.Sort Books");
            System.out.println("7.View Available Books");
            System.out.println("8.Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
            {
                case 1: 
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Year: ");
                    int year = sc.nextInt();

                    books.add(new Book(title, author, year));
                    System.out.println("Book added!");
                    break;
                case 2: 
                    for (int i = 0; i < books.size(); i++) 
                    {
                        System.out.print(i + ": ");
                        books.get(i).display();
                    }
                    break;
                case 3: 
                    System.out.print("Enter title: ");
                    String search = sc.nextLine();
                    for (Book b : books) {
                        if (b.getTitle().equalsIgnoreCase(search)) {
                            b.display();
                        }
                    }
                    break;

                case 4: 
                    System.out.print("Enter index: ");
                    int idx1 = sc.nextInt();
                    books.get(idx1).checkOut();
                    break;

                case 5: 
                    System.out.print("Enter index: ");
                    int idx2 = sc.nextInt();
                    books.get(idx2).returnBook();
                    break;

                case 6: 
                    System.out.println("1.Title  2.Author  3.Year");
                    int opt = sc.nextInt();

                    if (opt == 1) {
                        Collections.sort(books, Comparator.comparing(Book::getTitle));
                    } else if (opt == 2) {
                        Collections.sort(books, Comparator.comparing(Book::getAuthor));
                    } else {
                        Collections.sort(books, Comparator.comparingInt(Book::getYear));
                    }

                    System.out.println("Sorted!");
                    break;

                case 7:
                    for (Book b : books) {
                        if (b.isAvailable()) {
                            b.display();
                        }
                    }
                    break;
                case 8:
                    System.out.println("Exit...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}