import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Station extends TextualId implements Comparable, Serializable {

    private String id;
    private String address;
    private Type type;
    private String workingHours;
    private GeographicCoordinate geographicCoordinate;

    public Station(String id, String address, Type type, String workingHours, GeographicCoordinate geographicCoordinate) {
        this.id = id;
        this.address = address;
        this.type = type;
        this.workingHours = workingHours;
        this.geographicCoordinate = geographicCoordinate;
    }

    public Station() {
        this(null, null, null, null, null);
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws SQLException {
        this.address = address;

        String query = "update Station " +
                       "set address = '" + address + "' " +
                       "where id = '" + getId() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) throws SQLException {
        this.type = type;

        String query = "update Station " +
                "set type = '" + type + "' " +
                "where id = '" + getId() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) throws SQLException {
        this.workingHours = workingHours;

        String query = "update Station " +
                "set working_Hours = '" + workingHours + "' "+
                "where ID = '" + getId() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public GeographicCoordinate getGeographicCoordinate() {
        return geographicCoordinate;
    }

    public void setGeographicCoordinate(GeographicCoordinate geographicCoordinate) throws SQLException {
        this.geographicCoordinate = geographicCoordinate;

        String latQuery = "update Station " +
                "set LATITUDE = " + geographicCoordinate.getLatitude() + " "+
                "where ID = '" + getId() + "'";
        String lonQuery = "update Station " +
                "set LONGITUDE = " + geographicCoordinate.getLongitude() + " "+
                "where ID = '" + getId() + "'";
        connectToDB().execute(latQuery);
        connectToDB().execute(lonQuery);
        closeConnection();
    }

    @Override
    public void writeToDB() throws SQLException {
        String query = "insert into Station values('"
                + id + "', '" + address + "', '" + type + "', '" + workingHours + "', " + geographicCoordinate.getLatitude() + ", " + geographicCoordinate.getLongitude() + ")";
        connectToDB().execute(query);
        closeConnection();
    }

    @Override
    public void deleteFromDB() throws SQLException {
        String query = "DELETE FROM STATION WHERE ID = '" + getId() + "'";
        connectToDB().execute(query);
    }

    @Override
    public int compareTo(Object o) {
        if(o != null) {
            if(o instanceof Station) {
                Station station = (Station) o;
                return this.id.compareTo(station.getId());
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


