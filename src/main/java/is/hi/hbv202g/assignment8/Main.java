package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static LibrarySystem myLibrarySystem = new LibrarySystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        setupLibrary(); // Setup your library with books and users

        boolean running = true;
        while (running) {
            System.out.println("Welcome to the Library System");
            System.out.println("1. Borrow a book");
            System.out.println("2. Return a book");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    borrowBookInterface();
                    break;
                case 2:
                    returnBookInterface();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private static void setupLibrary() {
        // Add your initial library setup here (books, users, etc.)
    }

    private static void borrowBookInterface() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();

        try {
            User user = myLibrarySystem.findUserByName(userName);
            Book book = myLibrarySystem.findBookByTitle(bookTitle);
            myLibrarySystem.borrowBook(user, book);
            System.out.println("Book borrowed successfully.");
        } catch (UserOrBookDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void returnBookInterface() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();

        try {
            User user = myLibrarySystem.findUserByName(userName);
            Book book = myLibrarySystem.findBookByTitle(bookTitle);
            myLibrarySystem.returnBook(user, book);
            System.out.println("Book returned successfully.");
        } catch (UserOrBookDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }
}
