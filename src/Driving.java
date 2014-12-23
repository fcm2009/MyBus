/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Driving {

    private Driver driver;
    private Bus bus;

    public Driving(Driver driver, Bus bus) {
        this.driver = driver;
        this.bus = bus;
    }

    public Driving() {
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}