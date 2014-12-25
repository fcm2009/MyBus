import java.sql.SQLException;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Authorization extends SQLTable {

    private Driver driver;
    private Bus bus;

    public Authorization(Driver driver, Bus bus) {
        this.driver = driver;
        this.bus = bus;
    }

    public Authorization() {
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) throws SQLException {
        String query = "update AUTHORIZATION " +
        "set driver_id = " + driver.getId() + " " +
                "where driver_id = " + this.getDriver().getId() + " and BUS_ID = '" + this.getBus().getChassis() + "'";
        connectToDB().execute(query);
        closeConnection();

        this.driver = driver;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) throws SQLException {
        String query = "update AUTHORIZATION " +
                "set BUS_ID = '" + bus.getChassis() + "' " +
                "where driver_id = " + this.getDriver().getId() + " and BUS_ID = '" + this.getBus().getChassis() + "'";
        connectToDB().execute(query);
        closeConnection();

        this.bus = bus;
    }

    @Override
    public void writeToDB() throws SQLException {
        String query = "insert into AUTHORIZATION values("
                + driver.getId() + ", '" + bus.getChassis() + "')";
        connectToDB().execute(query);
    }

    @Override
    public void deleteFromDB() throws SQLException {
        String query = "DELETE FROM AUTHORIZATION WHERE BUS_ID = " + getBus().getChassis() + " AND DRIVER_ID = " + getDriver().getId();
        connectToDB().execute(query);
    }

}
