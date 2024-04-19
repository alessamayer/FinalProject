package is.hi.hbv202g.assignment8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.time.LocalDate;

public class LibrarySystemTest {
    private LibrarySystem library;

    @Before
    public void setUp() {
        library = new LibrarySystem();
    }

    @Test
    public void testAddAndFindBook() throws EmptyAuthorListException {
        String title = "Test Book";
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("Author Name"));
        library.addBookWithTitleAndAuthorList(title, authors);
        Book foundBook = library.findBookByTitle(title);
        Assert.assertNotNull("Book should be found", foundBook);
        Assert.assertEquals("Title should match", title, foundBook.getTitle());
    }

    @Test
    public void findNonExistingBook() {
        String title = "New Book";
        Book foundBook = library.findBookByTitle(title);
        Assert.assertNull("Book should not be found", foundBook);
    }

    @Test
    public void testAddAndFindStudentUser() {
        String name = "Test User";
        library.addStudentUser(name, true);
        User foundUser = library.findUserByName(name);
        Assert.assertNotNull("User should be found", foundUser);
        Assert.assertEquals("Name should match", name, foundUser.getName());
    }

    @Test
    public void testAddAndFindFacultyMemberUser() {
        String name = "Test User";
        library.addFacultyMemberUser(name, "Test Department");
        User foundUser = library.findUserByName(name);
        Assert.assertNotNull("User should be found", foundUser);
        Assert.assertEquals("Name should match", name, foundUser.getName());
    }

    @Test
    public void findNonExistingUser() {
        String name = "New User";
        User foundUser = library.findUserByName(name);
        Assert.assertNull("User should not be found", foundUser);
    }

    @Test
    public void testAddAndFindOmnibus() throws EmptyVolumeListException, EmptyAuthorListException {
        String title = "Test Omnibus";
        ArrayList<Book> volumes = new ArrayList<Book>();
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("Author Name"));
        Book volume1 = new Book("Volume 1", authors);
        Book volume2 = new Book("Volume 2", authors);
        volumes.add(volume1);
        volumes.add(volume2);

        library.addOmnibus(title, volumes, true);
        Omnibus foundOmnibus = library.findOmnibusByTitle(title);
        Assert.assertNotNull("Omnibus should be found", foundOmnibus);
        Assert.assertEquals("Title should match", title, foundOmnibus.getTitle());
    }

    @Test
    public void testBorrowAndReturnBook() throws Exception {
        String userName = "Test User";
        library.addStudentUser(userName, true); // Assuming this method exists and works correctly
        User user = library.findUserByName(userName);

        String bookTitle = "Borrowable Book";
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("Author Name"));
        library.addBookWithTitleAndAuthorList(bookTitle, authors);
        Book book = library.findBookByTitle(bookTitle);

        library.borrowBook(user, book);
        library.returnBook(user, book);
    }

    @Test
    public void testBorrowAndReturnOmnibus() throws Exception {
        ArrayList<Book> volumes = new ArrayList<Book>();
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("Author Name"));
        Book volume1 = new Book("Volume 1", authors);
        Book volume2 = new Book("Volume 2", authors);
        volumes.add(volume1);
        volumes.add(volume2);
        String omnibusTitle = "Test Omnibus";
        library.addOmnibus(omnibusTitle, volumes, true);

        String userName = "Omnibus User";
        library.addStudentUser(userName, true);
        User user = library.findUserByName(userName);

        Omnibus omnibus = library.findOmnibusByTitle(omnibusTitle);
        library.borrowOmnibus(user, omnibus);
        library.returnOmnibus(user, omnibus);
    }

    @Test
    public void testExtendLending() throws Exception {
        String userName = "Test User";
        library.addFacultyMemberUser(userName, "Test Department");
        User user = library.findUserByName(userName);

        String bookTitle = "Borrowable Book";
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("Author Name"));
        library.addBookWithTitleAndAuthorList(bookTitle, authors);
        Book book = library.findBookByTitle(bookTitle);
        library.borrowBook(user, book);
        library.extendLending((FacultyMember) user, book, LocalDate.now());
    }
}
