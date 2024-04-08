package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private final List<Book> books;
    private final List<Lending> lendings;
    private final List<User> users;

    LibrarySystem(){
        books = new ArrayList<Book>();
        lendings = new ArrayList<Lending>();
        users = new ArrayList<User>();
    }


    public void addBookWithTitleAndAuthorList(String title, ArrayList<Author> authors) throws EmptyAuthorListException {
        if (authors.isEmpty()){
            throw new EmptyAuthorListException("Empty author list");
        }
        Book newBook = new Book(title, authors);
        books.add(newBook);
    }
    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName){
        Book newBook = new Book(title, authorName);
        books.add(newBook);
    }
    public void addStudentUser(String name, boolean feePaid){
        Student newUser = new Student(name, feePaid);
        users.add(newUser);
    }
    public void addFacultyMemberUser(String name, String department){
        FacultyMember newUser = new FacultyMember(name, department);
        users.add(newUser);
    }
    public Book findBookByTitle(String title) {
        for (Book book : books){
            if (book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }
    public User findUserByName(String name) {
        for (User user : users){
            if (user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }
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
    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) throws UserOrBookDoesNotExistException {
        for (Lending lending : lendings){
            if (lending.getBook().equals(book) && lending.getUser().equals(facultyMember)){
                lending.setDueDate(newDueDate);
                return;
            }
        }
        throw new UserOrBookDoesNotExistException("Extending not possible");
    }
    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException{
        for (Lending lending : lendings){
            if (lending.getBook().equals(book) && lending.getUser().equals(user)){
                lendings.remove(lending);
                return;
            }
        }
        throw new UserOrBookDoesNotExistException("Returning not possible");
    }
}
