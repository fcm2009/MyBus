import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class MyBus {

    public Double reserveTicket(Type type, Customer customer, Trip trip) {
        Ticket ticket = new Ticket(type, customer, trip);
        trip.addTicket(ticket);
        customer.addTicket(ticket);
        try {
            ticket.writeToDB();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Internal Error, Try again");
        }
        return Ticket.calculatePrice(type, trip);
    }

    public void cancelTicket(Ticket ticket) {
        ticket.getCustomer().removeTicket(ticket);
        ticket.getTrip().removeTicket(ticket);
        try {
            ticket.deletefromDB();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Internal Error, Try again");
        }
    }

    public static Double calculatePrice(Type type, Trip trip) {
        return Ticket.calculatePrice(type, trip);
    }

}
