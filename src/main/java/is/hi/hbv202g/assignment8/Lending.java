package is.hi.hbv202g.assignment8;

import java.time.LocalDate;

/**
 * Class that represents a lending.
 * <p>
 * This class is to create lendings and it sets and gets the book, user and due date of the lending.</p>
 */
public class Lending {
    private Book book;
    private User user;
    private LocalDate dueDate;
    public Lending(Book book, User user){
        this.book = book;
        this.user = user;
        this.dueDate = LocalDate.now().plusDays(30);
    }

    /**
     * Gets the due date of the lending.
     *
     * @return due date
     */
    public LocalDate getDueDate(){
        return dueDate;
    }

    /**
     * Sets the due date of the lending.
     *
     * @param dueDate due date
     */
    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }

    /**
     * Gets the book of the lending.
     *
     * @return book
     */
    public Book getBook(){
        return book;
    }

    /**
     * Sets the book of the lending.
     *
     * @param book book
     */
    public void setBook(Book book){
        this.book = book;
    }

    /**
     * Gets the user of the lending.
     *
     * @return user
     */
    public User getUser(){
        return user;
    }

    /**
     * Sets the user of the lending.
     *
     * @param user user
     */
    public void setUser(User user){
        this.user = user;
    }
}
