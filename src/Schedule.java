import java.sql.SQLException;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Schedule extends SQLTable {

    private Route route;
    private Trip trip;

    public Schedule(Route route, Trip trip) {
        this.route = route;
        this.trip = trip;
    }

    public Schedule() {
        this(null, null);
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) throws SQLException{
        String query = "update SCHEDULE " +
                "set ROUTE_ID = '" + route.getId() + "' " +
                "where ROUTE_ID = '" + this.getRoute().getId() + "' and TRIP_ID = '" + this.getTrip().getId() + "'";
        connectToDB().execute(query);
        closeConnection();

        this.route = route;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) throws SQLException{
        String query = "update SCHEDULE " +
                "set TRIP_ID = '" + trip.getId() + "' " +
                "where ROUTE_ID = '" + this.getRoute().getId() + "' and TRIP_ID = '" + this.getTrip().getId() + "'";
        connectToDB().execute(query);
        closeConnection();

        this.trip = trip;
    }

    @Override
    public void writeToDB() throws SQLException {
        String query = "insert into SCHEDULE values( '"
                + route.getId() + "', " + trip.getId() + ")";
        connectToDB().execute(query);
    }

    @Override
    public void deleteFromDB() throws SQLException {
        String query = "DELETE FROM SCHEDULE WHERE ROUTE_ID = " + getRoute().getId() + " AND TRIP_ID = " + getTrip().getId();
        connectToDB().execute(query);
    }

}
