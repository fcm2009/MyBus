import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Station extends SQLTable implements Comparable, Serializable {

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

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public GeographicCoordinate getGeographicCoordinate() {
        return geographicCoordinate;
    }

    public void setGeographicCoordinate(GeographicCoordinate geographicCoordinate) {
        this.geographicCoordinate = geographicCoordinate;
    }

    @Override
    public void writeToDB() throws SQLException {
        String query = "insert into Station values('"
                + id + "', '" + address + "', '" + type + "', '" + workingHours + "', " + geographicCoordinate.getLatitude() + ", " + geographicCoordinate.getLongitude() + ")";
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


