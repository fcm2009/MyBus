import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Customer extends Person {

    private String username;
    private String password;
    private String email;
    private String dateOfBirth;
    private ArrayList<Ticket> ticketsList;


    public Customer(String id, String firstName, String middleName, String lastName, Gender gender, String phone, String username, String password, String email, String dateOfBirth) {
        super(id, firstName, middleName, lastName, gender, phone);
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.ticketsList = new ArrayList<Ticket>();
    }

    public Customer() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws SQLException {
        this.username = username;

        String query = "update customer " +
                "set username = '" + getUsername() + "' " +
                "where id = '" + getId() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws SQLException {
        this.password = password;

        String query = "update customer " +
                "set password = '" + getPassword() + "' " +
                "where id = '" + getId() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws SQLException {
        this.email = email;

        String query = "update customer " +
                "set email = '" + getEmail() + "' " +
                "where id = '" + getId() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws SQLException {
        this.dateOfBirth = dateOfBirth;

        String query = "update customer " +
                "set DATE_OF_BIRTH = '" + getDateOfBirth() + "' " +
                "where id = '" + getId() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public void addTicket(Ticket ticket) {
        this.ticketsList.add(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        this.ticketsList.remove(ticket);
    }

    @Override
    public void writeToDB() throws SQLException {
        String query = "insert into Customer values( "
                + getId() + ", '" + getGender() + "', '" + getFirstName() + "', '" + getMiddleName() + "', '" + getLastName()
                + "', '" + username + "', '" + dateOfBirth + "', " + getPhone() + ", '" + password + "', '" + email + "')";
        connectToDB().execute(query);
        closeConnection();
    }

    @Override
    public void deleteFromDB() throws SQLException {
        String query = "DELETE FROM CUSTOMER WHERE ID = " + getId();
        connectToDB().execute(query);
    }

}
