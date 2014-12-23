import java.util.ArrayList;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class MyBus {

    public Double reserveTicket(Type type, Customer customer, Trip trip) {
        Ticket ticket = new Ticket(type, customer, trip);
        trip.addTicket(ticket);
        customer.addTicket(ticket);
        return Ticket.calculatePrice(type, trip);
    }

    public void cancelTicket(Ticket ticket) {
        ticket.getTrip().removeTicket(ticket);
        ticket.getCustomer().removeTicket(ticket);
    }

    public static Double calculatePrice(Type type, Trip trip) {
        return Ticket.calculatePrice(type, trip);
    }

    public ArrayList<Trip> findTrip() {
        //sql
        return null;
    }

}
