import java.util.Date;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Driver extends Person {

    private String license;
    private Date employmentDate;

    public Driver(String id, String name, Gender gender, String phone, String license, Date employmentDate) {
        super(id, name, gender, phone);
        this.license = license;
        this.employmentDate = employmentDate;
    }

    public Driver() {
        this(null, null, null, null, null, null);
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

}
