import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Route extends TextualId implements Comparable, Serializable {

    private String id;
    private Double time;
    private ArrayList<Schedule> schedulesList;

    public Route(String id, Double time) {
        this.id = id;
        this.time = time;
        this.schedulesList = new ArrayList<Schedule>();
    }

    public Route() {
        this(null, null);
    }

    public String getId() {
        return id;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time)throws SQLException{
        this.time = time;

        String query = "update route " +
                "set time = " + time + " " +
                "where ID = '" + getId() + "' ";
        connectToDB().execute(query);
        closeConnection();
    }

    public void addSchedule(Schedule schedule) {
        schedulesList.add(schedule);
    }

    public void deleteSchedule(Schedule schedule) {
        schedulesList.remove(schedule);
    }

    @Override
    public void writeToDB() throws SQLException {
        String query = "insert into Route values( '"
                + getId() + "', " + time + ")";
        connectToDB().execute(query);
    }

    @Override
    public void deleteFromDB() throws SQLException {
        String query = "DELETE FROM ROUTE WHERE ID = " + getId();
        connectToDB().execute(query);
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
