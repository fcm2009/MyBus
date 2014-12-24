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

    public void setRoute(Route route) {
        this.route = route;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void writeToDB() throws SQLException {
        String query = "insert into Follows values( '"
                + route.getId() + "', '" + bus.getId() + "')";
        connectToDB().execute(query);
    }
}
