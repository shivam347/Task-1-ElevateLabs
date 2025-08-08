package Task3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

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

        while (true) {
            switch (choice) {
                case 1:

                    break;

                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid Choice:");
                    break;

            }
        }

    }

}
