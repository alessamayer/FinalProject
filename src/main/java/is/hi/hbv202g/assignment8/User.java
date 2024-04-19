package is.hi.hbv202g.assignment8;

/**
 * Class that represents a user.
 * <p>
 * This class is to create the users. This class can be extended to either student or faculty member. </p>
 */

public abstract class User {
    private String name;

    /**
     * Constructs a new User object with the specified name.
     *
     * @param name the name of the user
     */
    public User(String name){
        this.name = name;
    }

    /**
     * Returns the name of the user.
     *
     * @return the name of the user
     */
    public String getName(){
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the name of the user
     */
    public void setName(String name){
        this.name = name;
    }

}
