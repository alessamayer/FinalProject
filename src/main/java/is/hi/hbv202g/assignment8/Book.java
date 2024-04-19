package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.util.List;

/**
 * Book class.
 * <p>
 * This class represents a book. A book has a title and author(s).</p>
 */

public class Book {
    private String title;
    private ArrayList<Author> authors;

    public Book(String title, ArrayList<Author> authors) throws EmptyAuthorListException {
        if (authors.isEmpty()){
            throw new EmptyAuthorListException("Empty author list in Book constructor");
        }
        this.title = title;
        this.authors = authors;
    }

    /**
     * Get the list of authors.
     *
     * @return the list of authors
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * Set the list of authors.
     *
     * @param authors the list of authors
     * @throws EmptyAuthorListException if the list of authors is empty
     */
    public void setAuthors(ArrayList<Author> authors) throws EmptyAuthorListException {
        if (authors.isEmpty()){
            throw new EmptyAuthorListException("Empty author list in setAuthors");
        }
        this.authors = authors;
    }

    /**
     * Add an author to the list of authors.
     *
     * @param author
     */
    public void addAuthor(Author author){
        authors.add(author);
    }

    /**
     * Get the title of the book.
     *
     * @return the title of the book
     */
    public String getTitle(){
        return title;
    }

    /**
     * Set the title of the book.
     *
     * @param title the title of the book
     */
    public void setTitle(String title){
        this.title = title;
    }
}
