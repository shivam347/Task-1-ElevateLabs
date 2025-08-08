package Task3;

public class Book {

    // Instance variables 

    private String bookName;  
    private String author;
    private boolean isBorrowed;

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    // method which tell book is borrowed or not
    public boolean isBorrow(){

        return isBorrowed;
    }

    // method which make isBorrowed true is someone issued a book 
    public void borrowedBook(Book book){
        isBorrowed = true;
    }

    // method which make isBorrowed false if book is returned
    public void returnBook(Book book){
        isBorrowed = false;
    }

    @Override
    public String toString() {
        return "Book [bookName=" + bookName + ", author=" + author + ", isBorrowed=" + isBorrowed + "]";
    }





    

    

    
}
