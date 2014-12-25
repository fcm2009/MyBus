import java.sql.SQLException;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Plan extends SQLTable {

    private Route route;
    private Bus bus;

    public Plan(Route route, Bus bus) {
        this.route = route;
        this.bus = bus;
    }

    public Plan() {
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route)throws SQLException{
        String query = "update PLAN " +
                "set ROUTE_ID = '" + route.getId() + "' " +
                "where ROUTE_ID = '" + this.getRoute().getId() + "' and BUS_ID = '" + getBus().getChassis() + "'";
        connectToDB().execute(query);
        closeConnection();

        this.route = route;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) throws SQLException {
        String query = "update PLAN " +
                "set BUS_ID = '" + bus.getChassis() + "' " +
                "where ROUTE_ID = '" + this.getRoute().getId() + "' and BUS_ID = '" + getBus().getChassis() + "'";
        connectToDB().execute(query);
        closeConnection();

        this.bus = bus;
    }

    @Override
    public void writeToDB() throws SQLException {
        String query = "insert into PLAN values( '"
                + getRoute().getId() + "', '" + getBus().getChassis() + "')";
        connectToDB().execute(query);
    }

    @Override
    public void deleteFromDB() throws SQLException {
        String query = "DELETE FROM PLAN WHERE BUS_ID = " + getBus().getChassis() + " AND ROUTE_ID = " + getRoute().getId();
        connectToDB().execute(query);
    }

}
