package Task3;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String department;

    private List<Book> Books;

    public User(String name, String department) {
        this.name = name;
        this.department = department;
        this.Books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public List<Book> getBooks() {
        return Books;
    }

    public void borrrowBooks(Book book) {

        Books.add(book);

        book.borrowedBook(book); // method call from book to mark book is returned

    }

    public void returnBooks(Book book) {
        Books.remove(book);
        book.returnBook(book); // method call from book class to mark book is returned;
    }

}