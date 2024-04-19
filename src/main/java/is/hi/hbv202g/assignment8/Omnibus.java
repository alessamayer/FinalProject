package is.hi.hbv202g.assignment8;
import java.util.ArrayList;
import java.util.List;

public class Omnibus {
    private final String title;
    private List<Book> volumes = new ArrayList<>();
    boolean isAvailable;

    public Omnibus(String title, List<Book> volumes, boolean isAvailable) {
        this.title = title;
        this.volumes = volumes;
        this.isAvailable = isAvailable;
    }
    public List<Book> getVolumes() {
        return volumes;
    }

    public Object getTitle() {
        return title;
    }
}
