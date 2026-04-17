class Book {
    private String title;
    private String author;
    private int year;
    private boolean isAvailable = true;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public boolean isAvailable() { return isAvailable; }

    public void checkOut() 
    {
        if (isAvailable) 
        {
            isAvailable = false;
            System.out.println("Book checked out!");
        } else {
            System.out.println("Already borrowed!");
        }
    }
    public void returnBook() {
        isAvailable = true;
        System.out.println("Book returned!");
    }

    public void display() {
        System.out.println(title + " | " + author + " | " + year +
                " | " + (isAvailable ? "Available" : "Not Available"));
    }
}