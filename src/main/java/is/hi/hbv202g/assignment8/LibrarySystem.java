package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents the library system.
 * <p>
 * This class handles the library system with its books, lendings and users. </p>
 */

public class LibrarySystem {
    private final List<Book> books;
    private final List<Omnibus> omnibuses;
    private final List<Lending> lendings;
    private final List<User> users;

    LibrarySystem(){
        books = new ArrayList<Book>();
        omnibuses = new ArrayList<Omnibus>();
        lendings = new ArrayList<Lending>();
        users = new ArrayList<User>();
    }

    /**
     * Adds a new book to the library system.
     *
     * @param title
     * @param authors
     * @throws EmptyAuthorListException
     */
    public void addBookWithTitleAndAuthorList(String title, ArrayList<Author> authors) throws EmptyAuthorListException {
        if (authors.isEmpty()){
            throw new EmptyAuthorListException("Empty author list");
        }
        Book newBook = new Book(title, authors);
        books.add(newBook);
    }

    /**
     * Adds a new book collection to the library system.
     *
     * @param title
     * @param volumes
     * @param isAvailable
     * @throws EmptyVolumeListException
     */
    public void addOmnibus(String title, List<Book> volumes, boolean isAvailable) throws EmptyVolumeListException{
        if (volumes.isEmpty()){
            throw new EmptyVolumeListException("Empty volume list");
        }
        Omnibus newOmnibus = new Omnibus(title, volumes, isAvailable);
        omnibuses.add(newOmnibus);
    }

    /**
     * Adds a new student user to the library system.
     *
     * @param name
     * @param feePaid
     */
    public void addStudentUser(String name, boolean feePaid){
        Student newUser = new Student(name, feePaid);
        users.add(newUser);
    }

    /**
     * Adds a new faculty member user to the library system.
     *
     * @param name
     * @param department
     */
    public void addFacultyMemberUser(String name, String department){
        FacultyMember newUser = new FacultyMember(name, department);
        users.add(newUser);
    }

    /**
     * Find a book in the library system by its title.
     *
     * @param title
     * @return the book with the given title or null if not found
     */
    public Book findBookByTitle(String title) {
        for (Book book : books){
            if (book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }

    /**
     * Find a book collection omnibus in the library system by its title.
     *
     * @param title
     * @return the book collection omnibus with the given title or null if not found
     */
    public Omnibus findOmnibusByTitle(String title) {
        for (Omnibus omnibus : omnibuses){
            if (omnibus.getTitle().equals(title)){
                return omnibus;
            }
        }
        return null;
    }

    /**
     * Find a user in the library system by its name.
     *
     * @param name
     * @return the user with the given name or null if not found
     */
    public User findUserByName(String name) {
        for (User user : users){
            if (user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    /**
     * Borrow a book.
     *
     * @param user
     * @param book
     * @throws UserOrBookDoesNotExistException
     */
    public void borrowBook(User user, Book book) throws UserOrBookDoesNotExistException{
        if (user instanceof Student){
            Lending newLending = new Lending(book, user);
            lendings.add(newLending);
        }
        else if (user instanceof FacultyMember){
            Lending newLending = new Lending(book, user);
            lendings.add(newLending);
        }
        else {
            throw new UserOrBookDoesNotExistException("User does not exist");
        }
    }

    /**
     * Borrow a book collection omnibus.
     *
     * @param user
     * @param omnibus
     * @throws UserOrBookDoesNotExistException
     */
    public void borrowOmnibus(User user, Omnibus omnibus) throws UserOrBookDoesNotExistException{
        for(Book book : omnibus.getVolumes()){
            borrowBook(user, book);
        }
        omnibus.isAvailable = false;
    }

    /**
     * Extend a lending.
     *
     * @param facultyMember
     * @param book
     * @param newDueDate
     * @throws UserOrBookDoesNotExistException
     */
    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) throws UserOrBookDoesNotExistException {
        for (Lending lending : lendings){
            if (lending.getBook().equals(book) && lending.getUser().equals(facultyMember)){
                lending.setDueDate(newDueDate);
                return;
            }
        }
        throw new UserOrBookDoesNotExistException("Extending not possible");
    }

    /**
     * Return a book.
     *
     * @param user
     * @param book
     * @throws UserOrBookDoesNotExistException
     */
    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException{
        for (Lending lending : lendings){
            if (lending.getBook().equals(book) && lending.getUser().equals(user)){
                lendings.remove(lending);
                return;
            }
        }
        throw new UserOrBookDoesNotExistException("Returning not possible");
    }

    /**
     * Return a book collection omnibus.
     *
     * @param user
     * @param omnibus
     * @throws UserOrBookDoesNotExistException
     */
    public void returnOmnibus(User user, Omnibus omnibus) throws UserOrBookDoesNotExistException{
        for(Book book : omnibus.getVolumes()){
            returnBook(user, book);
        }
        omnibus.isAvailable = true;
    }
}
