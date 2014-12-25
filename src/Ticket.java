import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Ticket extends NumericalId implements Comparable, Serializable {

    private String id;
    private Double price;
    private Type type;
    private Customer customer;
    private Trip trip;

    public Ticket(String id, Double price, Type type, Customer customer, Trip trip) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.customer = customer;
        this.trip = trip;
    }

    public Ticket(String id, Type type, Customer customer, Trip trip) {
        this(id, calculatePrice(type, trip), type, customer, trip);
    }

    public Ticket() {
        this(null, null, null, null, null);
    }

    public String getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) throws SQLException{
        this.price = price;

        String query = "update ticket " +
                "set price = " + price + " " +
                "where ID = " + getId();
        connectToDB().execute(query);
        closeConnection();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) throws SQLException {
        this.type = type;

        String query = "update SCHEDULE " +
                "set class = '" + getType() + "' " +
                "where tnum = " + getId();
        connectToDB().execute(query);
        closeConnection();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) throws SQLException {
        this.customer = customer;

        String query = "update SCHEDULE " +
                "set cid = " + getCustomer().getId() + " " +
                "where tnum = " + getId();
        connectToDB().execute(query);
        closeConnection();

    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) throws SQLException {
        this.trip = trip;

        String query = "update SCHEDULE " +
                "set tid = " + getTrip().getId() + " " +
                "where tnum = " + getId();
        connectToDB().execute(query);
        closeConnection();
    }

    public static Double calculatePrice(Type type, Trip trip) {
        GeographicCoordinate fromGS = trip.getDepartureStation().getGeographicCoordinate();
        GeographicCoordinate toGS = trip.getArrivalStation().getGeographicCoordinate();
        if(type == Type.STANDARD)
            return fromGS.calculateDistance(toGS) * 0.25;
        else
            return fromGS.calculateDistance(toGS) * 0.30;
    }

    @Override
    public void writeToDB() throws SQLException {
        String query = "insert into Ticket values("
                + id + ", " + price + ", '" + type + "', " + customer.getId() + ", " + trip.getId() + ")";
        connectToDB().execute(query);
    }

    @Override
    public void deleteFromDB() throws SQLException {
        String query = "DELETE FROM TICKET WHERE ID = " +  getId();
        connectToDB().execute(query);
    }

    @Override
    public int compareTo(Object o) {
        if(o != null) {
            if(o instanceof Ticket) {
                Ticket ticket = (Ticket) o;
                return this.id.compareTo(ticket.getId());
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
