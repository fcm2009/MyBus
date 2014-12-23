import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Trip implements Comparable, Serializable {

    private String id;
    private Type type;
    private WeekDays weekDays;
    private Date arrivalTime;
    private Date departureTime;
    private Station arrivalStation;
    private Station departureStation;

    public Trip(String id, Type type, WeekDays weekDays, Date arrivalTime, Date departureTime, Station arrivalStation, Station departureStation) {
        this.id = id;
        this.type = type;
        this.weekDays = weekDays;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.arrivalStation = arrivalStation;
        this.departureStation = departureStation;

    }

    public Trip(String id, Type type) {
        this(null, null, null, null, null, null, null);
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

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
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
