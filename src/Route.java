import java.io.Serializable;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Route implements Comparable, Serializable {

    private String id;
    private double time;

    public Route(String id, double time) {
        this.id = id;
        this.time = time;
    }

    public Route() {
        this(null, 0.0);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public int compareTo(Object o) {
        if(o != null) {
            if(o instanceof Route) {
                Route route = (Route) o;
                return this.id.compareTo(route.getId());
            }
            else
                throw new ClassCastException();
        }
        else
            throw new NullPointerException();
    }

    @Override
    public boolean equals(Object obj) {
        return this.compareTo(obj) == 0;
    }

}
