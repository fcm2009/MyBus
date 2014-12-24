import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Driver extends Person {

    private String license;
    private String employmentDate;

    public Driver(String id, String firstName, String middleName, String lastName, Gender gender, String phone, String license, String employmentDate) {
        super(id, firstName, middleName, lastName, gender, phone);
        this.license = license;
        this.employmentDate = employmentDate;
    }

    public Driver() {
        this(null, null, null, null, null, null, null, null);
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(String employmentDate) {
        this.employmentDate = employmentDate;
    }

    @Override
    public void writeToDB() throws SQLException {
        String query = "insert into Driver values( '"
                + getFirstName() + "', " + getId() + ", " + getPhone() + ", '" + getGender() + "', " + getLicense()
                + ", '" + employmentDate + "')";
        connectToDB().execute(query);
    }
}
