import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Trip implements Comparable, Serializable {

    private String id;
    private Type type;
    private WeekDays weekDays;
    private Date arrival;
    private Date departure;

    public Trip(String id, Type type, WeekDays weekDays, Date arrival, Date departure) {
        this.id = id;
        this.type = type;
        this.weekDays = weekDays;
        this.arrival = arrival;
        this.departure = departure;
    }

    public Trip(String id, Type type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public WeekDays getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(WeekDays weekDays) {
        this.weekDays = weekDays;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    @Override
    public int compareTo(Object o) {
        if(o != null) {
            if(o instanceof Trip) {
                Trip trip = (Trip) o;
                return this.id.compareTo(trip.getId());
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
