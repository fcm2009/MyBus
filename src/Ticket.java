import java.io.Serializable;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Ticket implements Comparable, Serializable {

    private String id;
    private double price;
    private Type type;
    private Customer customer;
    private Trip trip;

    public Ticket(String id, double price, Type type, Customer customer, Trip trip) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.customer = customer;
        this.trip = trip;
    }

    public Ticket(String id, Type type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
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