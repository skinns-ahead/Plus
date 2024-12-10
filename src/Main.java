import java.util.*;

class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}

class Book {
    private String title;
    private Author author;
    private String genre;

    public Book(String title, Author author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Author: %s, Genre: %s", title, author, genre);
    }
}

class Library {
    private List<Book> books;
    private Set<Author> authors;
    private Map<String, List<Book>> booksByGenre;

    public Library() {
        this.books = new ArrayList<>();
        this.authors = new HashSet<>();
        this.booksByGenre = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        authors.add(book.getAuthor());
        booksByGenre.computeIfAbsent(book.getGenre(), k -> new ArrayList<>()).add(book);
    }

    public void printBooks() {
        System.out.println("Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void printAuthors() {
        System.out.println("Authors:");
        for (Author author : authors) {
            System.out.println(author);
        }
    }

    public void printBooksByGenre() {
        System.out.println("Books by Genre:");
        for (Map.Entry<String, List<Book>> entry : booksByGenre.entrySet()) {
            System.out.println("Genre: " + entry.getKey());
            for (Book book : entry.getValue()) {
                System.out.println(book);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Author author1 = new Author("J.K. Rowling");
        Author author2 = new Author("George Orwell");

        Book book1 = new Book("Harry Potter and the Philosopher's Stone", author1, "Fantasy");
        Book book2 = new Book("1984", author2, "Dystopian");
        Book book3 = new Book("Animal Farm", author2, "Satire");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.printBooks();
        library.printAuthors();
        library.printBooksByGenre();
    }
}
