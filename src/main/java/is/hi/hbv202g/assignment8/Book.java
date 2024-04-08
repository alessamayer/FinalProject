package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private ArrayList<Author> authors;

    public Book(String title, String authorName){
        this.title = title;
        this.authors = new ArrayList<Author>();
        this.authors.add(new Author(authorName));
    }

    public Book(String title, ArrayList<Author> authors) throws EmptyAuthorListException {
        if (authors.isEmpty()){
            throw new EmptyAuthorListException("Empty author list in Book constructor");
        }
        this.title = title;
        this.authors = authors;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) throws EmptyAuthorListException {
        if (authors.isEmpty()){
            throw new EmptyAuthorListException("Empty author list in setAuthors");
        }
        this.authors = authors;
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
