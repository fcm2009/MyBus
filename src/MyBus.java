import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class MyBus {

    public Double reserveTicket(Type type, Customer customer, Trip trip) {
        Ticket ticket = new Ticket("" ,type, customer, trip);
        customer.addTicket(ticket);
        trip.addTicket(ticket);
        try {
            ticket.writeToDB();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Internal Error, Try again");
        }
        return Ticket.calculatePrice(type, trip);
    }

    public void cancelTicket(Ticket ticket) {
        ticket.getCustomer().deleteTicket(ticket);
        ticket.getTrip().deleteTicket(ticket);
        try {
            ticket.writeToDB();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Internal Error, Try again");
        }
    }

}
