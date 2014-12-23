import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Customer extends Person {

    private String username;
    private String password;
    private String email;
    private Date dateOfBearth;

    public Customer(String id, String name, Gender gender, String phone, String username, String password, String email, Date dateOfBearth) {
        super(id, name, gender, phone);
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateOfBearth = dateOfBearth;
    }

    public Customer() {
        this(null, null, null, null, null, null, null, null);
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

    public Date getDateOfBearth() {
        return dateOfBearth;
    }

    public void setDateOfBearth(Date dateOfBearth) {
        this.dateOfBearth = dateOfBearth;
    }

}
