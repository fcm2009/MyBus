import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Trip extends NumericalId implements Comparable, Serializable {

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) throws SQLException {
        this.type = type;

        String query = "update TRIP_INSTANCE " +
                "set type = '" + getType() + "' " +
                "where TRIP_ID = " + getId();
        connectToDB().execute(query);
        closeConnection();
    }

    public WeekDays getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(WeekDays weekDays) throws SQLException {
        this.weekDays = weekDays;

        String query = "update TRIP_INSTANCE " +
                "set weekdays = '" + getWeekDays() + "' " +
                "where TRIP_ID = " + getId();
        connectToDB().execute(query);
        closeConnection();
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) throws SQLException {
        this.arrivalTime = arrivalTime;

        String query = "update TRIP_INSTANCE " +
                "set ARRIVAL_TIME = '" + getArrivalTime() + "' " +
                "where TRIP_ID = " + getId();
        connectToDB().execute(query);
        closeConnection();
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) throws SQLException {
        this.departureTime = departureTime;

        String query = "update TRIP_INSTANCE " +
                "set DEPARTURE_TIME = '" + getDepartureTime() + "' " +
                "where TRIP_ID = " + getId();
        connectToDB().execute(query);
        closeConnection();
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(Station arrivalStation) throws SQLException {
        this.arrivalStation = arrivalStation;

        String query = "update TRIP_INSTANCE " +
                "set type = '" + getType() + "' " +
                "where ARRIVAL_STATION = " + getArrivalStation();
        connectToDB().execute(query);
        closeConnection();
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) throws SQLException {
        this.departureStation = departureStation;

        String query = "update TRIP_INSTANCE " +
                "set DEPARTURE_STATION = '" + getType() + "' " +
                "where TRIP_ID = " + getId();
        connectToDB().execute(query);
        closeConnection();
    }

    public void addSchedule(Schedule schedule) {
        schedulesList.add(schedule);
    }

    public void deleteSchedule(Schedule schedule) {
        schedulesList.remove(schedule);
    }

    public void addTicket(Ticket ticket) {
        this.ticketsList.add(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        this.ticketsList.remove(ticket);
    }

    @Override
    public void writeToDB() throws SQLException {
        String query = "insert into TRIP values("
                + id + ", '" + type + "', '" + weekDays + "', '" + arrivalTime + "', '" + departureTime + "', '" + arrivalStation + "', '" + departureStation + "')";
        connectToDB().execute(query);
        closeConnection();
    }

    @Override
    public void deleteFromDB() throws SQLException {
        String query = "DELETE FROM TRIP_INSTANCE WHERE TRIP_ID = " + getId();
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
