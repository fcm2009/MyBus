import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Driver extends Person {

    private String license;
    private String employmentDate;
    private ArrayList<Authorization> authorizationList;

    public Driver(String id, String firstName, String middleName, String lastName, Gender gender, String phone, String license, String employmentDate) {
        super(id, firstName, middleName, lastName, gender, phone);
        this.license = license;
        this.employmentDate = employmentDate;
        this.authorizationList = new ArrayList<Authorization>();
    }

    public Driver() {
        this(null, null, null, null, null, null, null, null);
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) throws SQLException {
        this.license = license;

        String query = "update Driver " +
                "set license = " + getLicense() + " " +
                "where id = '" + getId() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(String employmentDate) throws SQLException {
        this.employmentDate = employmentDate;

        String query = "update Driver " +
                "set employmentDate = '" + getEmploymentDate() + "' " +
                "where id = '" + getId() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public void addAuthorization(Authorization authorization) {
        this.authorizationList.add(authorization);
    }

    public void deleteAuthorization(Authorization authorization) {
        this.authorizationList.remove(authorization);
    }

    @Override
    public void writeToDB() throws SQLException {
        String query = "insert into Driver values( '"
                + getFirstName() + "', " + getId() + ", " + getPhone() + ", '" + getGender() + "', " + getLicense()
                + ", '" + employmentDate + "')";
        connectToDB().execute(query);
    }

    @Override
    public void deleteFromDB() throws SQLException {
        String query = "DELETE FROM DRIVER WHERE ID = " + getId();
        connectToDB().execute(query);
    }

}
