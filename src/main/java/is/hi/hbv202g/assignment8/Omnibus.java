package is.hi.hbv202g.assignment8;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents an omnibus.
 * <p>
 * This class is used for book collections. It contains a list of books and a title </p>
 */

public class Omnibus {
    private final String title;
    private List<Book> volumes = new ArrayList<>();
    boolean isAvailable;

    public Omnibus(String title, List<Book> volumes, boolean isAvailable) {
        this.title = title;
        this.volumes = volumes;
        this.isAvailable = isAvailable;
    }

    /**
     * returns the list of books in the omnibus
     *
     * @return the list of books
     */
    public List<Book> getVolumes() {
        return volumes;
    }

    /**
     * returns the title of the omnibus
     *
     * @return the title
     */
    public Object getTitle() {
        return title;
    }
}
