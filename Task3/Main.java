package Task3;

import java.util.Scanner;
/* Main class with implementatin of all methods like Library Management System */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        while (true) {
            System.out.println("***********Library Management System***************");

            System.out.println("1: Register User");
            System.out.println("2: Add Books");
            System.out.println("3: Show All Books");
            System.out.println("4: Borrow Books");
            System.out.println("5: Return Books");
            System.out.println("6: show user Borrowed Books");
            System.out.println("0: Exit");

            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();// to consume next line

            switch (choice) {
                case 1:
                    System.out.print("Enter Your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Your department: ");
                    String department = sc.nextLine();
                    library.registerUser(name, department);
                    break;

                case 2:

                    System.out.print("Enter the Book-Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter the author-name: ");
                    String author = sc.nextLine();
                    library.addBooks(title, author);
                    break;

                case 3:

                    library.showAllBooks();
                    break;

                case 4:

                    System.out.print("Enter Your name: ");
                    String user = sc.nextLine();
                    System.out.print("Enter Your department: ");
                    String depart = sc.nextLine();
                    System.out.print("Enter the Book-Title: ");
                    String bookName = sc.nextLine();
                    library.borrowBook(user, depart, bookName);
                    break;

                case 5:
                    System.out.print("Enter Your name: ");
                    String user01 = sc.nextLine();
                    System.out.print("Enter the Book-Title: ");
                    String bookname = sc.nextLine();
                    library.returnBook(user01, bookname);
                    break;

                case 6:
                    System.out.print("Enter Your name: ");
                    String name01 = sc.nextLine();
                    library.userBorrowedBooks(name01);
                    break;

                case 0:
                    System.out.println("You have Succesfully Exit");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice:");
                    break;

            }
        }

    }

    

}
