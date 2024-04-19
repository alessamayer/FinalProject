package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static final LibrarySystem newLibrarySystem = new LibrarySystem();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws UserOrBookDoesNotExistException, EmptyAuthorListException, EmptyVolumeListException {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to the Library System");
            System.out.println("1: Add a book with author(s)");
            System.out.println("2: Add a book collection. (Please enter books beforehand)");
            System.out.println("3: Add a student user");
            System.out.println("4: Add a faculty member user");
            System.out.println("5: Find book by title");
            System.out.println("6: Find book collection by title");
            System.out.println("7: Find user by name");
            System.out.println("8: Borrow a book");
            System.out.println("9: Extend lending");
            System.out.println("10: Return book");
            System.out.println("0: Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    addBookInterface();
                    break;
                case 2:
                    addOmnibusInterface();
                    break;
                case 3:
                    addStudentUserInterface();
                    break;
                case 4:
                    addFacultyMemberUserInterface();
                    break;
                case 5:
                    findBookInterface();
                    break;
                case 6:
                    findOmnibusInterface();
                    break;
                case 7:
                    findUserInterface();
                    break;
                case 8:
                    borrowBookInterface();
                    break;
                case 9:
                    extendLendingInterface();
                    break;
                case 10:
                    returnBookInterface();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        }
    }

    private static void addBookInterface() throws EmptyAuthorListException {
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.print("Enter number of authors: ");
        int numberOfAuthors = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        ArrayList<Author> authors = new ArrayList<Author>();
        for (int i = 0; i < numberOfAuthors; i++) {
            System.out.print("Enter author name: ");
            String authorName = scanner.nextLine();
            Author author = new Author(authorName);
            authors.add(author);
        }
        newLibrarySystem.addBookWithTitleAndAuthorList(bookTitle, authors);
        System.out.println("Book added successfully.");
    }

    private static void addOmnibusInterface() throws EmptyVolumeListException {
        ArrayList<Book> volumes = new ArrayList<Book>();
        System.out.print("Enter book collection title: ");
        String omnibusTitle = scanner.nextLine();
        System.out.print("Enter number of books in the collection: ");
        int numberOfBooks = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println("Enter book title: ");
            String bookTitle = scanner.nextLine();
            Book book = newLibrarySystem.findBookByTitle(bookTitle);
            if (book == null) {
                System.out.println("Book not found.");
                return;
            }
            volumes.add(book);
        }
        newLibrarySystem.addOmnibus(omnibusTitle, volumes, true);
        System.out.println("Omnibus added successfully.");
    }

    private static void addStudentUserInterface() {
        System.out.print("If fee is paid, enter user name: ");
        String userName = scanner.nextLine();
        boolean feePaid = true;
        newLibrarySystem.addStudentUser(userName, feePaid);
        System.out.println("User added successfully.");
    }

    private static void addFacultyMemberUserInterface() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        newLibrarySystem.addFacultyMemberUser(userName, department);
        System.out.println("User added successfully.");
    }

    private static void findBookInterface() {
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();
        Book book = newLibrarySystem.findBookByTitle(bookTitle);
        if (book == null) {
            System.out.println("Book not found.");
        } else {
            System.out.println("Book exists in library");
        }
    }

    private static void findOmnibusInterface() {
        System.out.print("Enter omnibus title: ");
        String omnibusTitle = scanner.nextLine();
        Omnibus omnibus = newLibrarySystem.findOmnibusByTitle(omnibusTitle);
        if (omnibus == null) {
            System.out.println("Omnibus not found.");
        } else {
            System.out.println("Omnibus exists in library");
        }
    }

    private static void findUserInterface() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        User user = newLibrarySystem.findUserByName(userName);
        if (user == null) {
            System.out.println("User not found.");
        } else {
            System.out.println("User exists in library");
        }
    }

    private static void borrowBookInterface() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();

        try {
            User user = newLibrarySystem.findUserByName(userName);
            Book book = newLibrarySystem.findBookByTitle(bookTitle);
            newLibrarySystem.borrowBook(user, book);
            System.out.println("Book borrowed successfully.");
        } catch (UserOrBookDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void extendLendingInterface() throws UserOrBookDoesNotExistException {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        User user = newLibrarySystem.findUserByName(userName);
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();
        Book book = newLibrarySystem.findBookByTitle(bookTitle);
        newLibrarySystem.extendLending((FacultyMember) user, book, LocalDate.now().plusDays(30));
        System.out.println("Lending extended successfully.");
    }

    private static void returnBookInterface() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();

        try {
            User user = newLibrarySystem.findUserByName(userName);
            Book book = newLibrarySystem.findBookByTitle(bookTitle);
            newLibrarySystem.returnBook(user, book);
            System.out.println("Book returned successfully.");
        } catch (UserOrBookDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }
}
