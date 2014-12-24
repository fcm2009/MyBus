import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Trip extends SQLTable implements Comparable, Serializable {

    private String id;
    private Type type;
    private WeekDays weekDays;
    private String arrivalTime;
    private String departureTime;
    private Station arrivalStation;
    private Station departureStation;
    private ArrayList<Schedule> schedulesList;
    private ArrayList<Ticket> ticketsList;

    public Trip(String id, Type type, WeekDays weekDays, String arrivalTime, String departureTime, Station arrivalStation, Station departureStation) {
        this.id = id;
        this.type = type;
        this.weekDays = weekDays;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.arrivalStation = arrivalStation;
        this.departureStation = departureStation;
        this.schedulesList = new ArrayList<Schedule>();
        this.ticketsList = new ArrayList<Ticket>();
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

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
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

    public void addSchedule(Schedule schedule) {
        schedulesList.add(schedule);
    }

    public void removeSchedule(Schedule schedule) {
        schedulesList.remove(schedule);
    }

    public void addTicket(Ticket ticket) {
        this.ticketsList.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        this.ticketsList.remove(ticket);
    }

    @Override
    public void writeToDB() throws SQLException {
        String query = "insert into Trip_ values("
                + id + ", '" + type + "', '" + weekDays + "', '" + arrivalTime + "', '" + departureTime + "', '" + arrivalStation + "', '" + departureStation + "')";
        connectToDB().execute(query);
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
