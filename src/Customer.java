import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Customer extends Person {

    private String username;
    private String password;
    private String email;
    private String dateOfBearth;
    private ArrayList<Ticket> ticketsList;


    public Customer(String id, String firstName, String middleName, String lastName, Gender gender, String phone, String username, String password, String email, String dateOfBearth) {
        super(id, firstName, middleName, lastName, gender, phone);
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateOfBearth = dateOfBearth;
        this.ticketsList = new ArrayList<Ticket>();
    }

    public Customer() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBearth() {
        return dateOfBearth;
    }

    public void setDateOfBearth(String dateOfBearth) {
        this.dateOfBearth = dateOfBearth;
    }

    public void addTicket(Ticket ticket) {
        this.ticketsList.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        this.ticketsList.remove(ticket);
    }

    @Override
    public void writeToDB() throws SQLException {
        String query = "insert into Customer values( "
                + getId() + ", '" + getGender() + "', '" + getFirstName() + "', '" + getMiddleName() + "', '" + getLastName()
                + "', '" + username + "', '" + dateOfBearth + "', " + getPhone() + ", '" + password + "', '" + email + "')";
        connectToDB().execute(query);
    }

}
