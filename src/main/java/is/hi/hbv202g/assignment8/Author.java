package is.hi.hbv202g.assignment8;
/**
 * Class that represents an author.
 * <p>
 * This class sets and gets the author's name </p>
 */
public class Author {
    private String name;
    /**
     * Creates author.
     * @param name the author's name
     */
    public Author(String name){
        this.name = name;
    }

    /**
     * Returns the author's name.
     * @return the author's name
     */
    public String getName(){
        return name;
    }
    /**
     * Sets the name of the author.
     * @param name the author's name
     */
    public void setName(String name){
        this.name = name;
    }
}
