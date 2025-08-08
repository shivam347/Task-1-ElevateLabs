package Task3;

import java.util.*;

public class Library {

    List<Book> libraryBooks; 
    List<User> users;


    public Library(){
        libraryBooks = new ArrayList<>();
        users = new ArrayList<>();
    }


    // Method to add the books
    public void addBooks(String title, String author){
        libraryBooks.add(new Book(title, author));
    }

/* Method to register user to the library system */
    public void registerUser(String name, String department){
        users.add(new User(name, department));
    }

    /* Method to show all the books */
    public void showAllBooks(){
        for(Book book : libraryBooks){

            System.out.println(book);
        }
    }

/* Method to find the User  */
    private User findUser(String name){

        for(User user : users){

            if(user.getName().equalsIgnoreCase(name)){

                return user;
            }
        }

        return null;

    }

    /* Method to findAvailable books in library */
    public Book findAvailableBook(String title){

        for(Book book : libraryBooks){
            if(book.getBookName().equalsIgnoreCase(title)){
                return book;
            }
        }

        return null;
    }

    /* Method to borrow a book */
    public void borrowBook(String name,String department, String title){

        User user = findUser(name);
        Book book = findAvailableBook(title);

        if(user == null){
            System.out.println("User not Found..");
        }else if(book == null){
            System.out.println("Sorry! Book is not Available");
        }else{
            user.borrrowBooks(book);

            System.out.println(name + "of department "+ department+" has borrowed a book name: " + title);
        }


    }

/* Method to return the borrowed books */
    public void returnBook(String name, String title){

        // check user has borrowed any book or not 
        User user = findUser(name);

        if(user == null){
            System.out.println("User not found...");
            return;
        }

        // I have to make sure book return should be book borrowed by that user
        for(Book book : user.getBooks()){
            
            if(book.getBookName().equalsIgnoreCase(title)){
                  
                user.returnBooks(book);

                System.out.println(name +" has successfully returned the book name: "+ title);
                return;
            }

        }

        // what if book is not the issued book by user then
        System.out.println(user +" has not borrowed "+ title);
        return;
    }

    /* Method to show the all book borrowed by that particular user */
    public void userBorrowedBooks(String name){

        User user = findUser(name);


        if(user == null){
            
            System.out.println("No user found by the name"+ user);
            return;
        }

        if(user.getBooks().isEmpty()){
            System.out.println(name+ " Has not borrowed any book");
            return;
        }

        for(Book book : user.getBooks()){

            System.out.println(book.getBookName()+ "Author is: "+book.getAuthor());

            System.out.println("-------------------------------------------------------------");
            
        }

        



    }
    
    
}
