import java.sql.SQLException;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public abstract class Person extends NumericalId implements Comparable {

    private String id;
    private Gender gender;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phone;

    public Person(String id, String firstName, String middleName, String lastName, Gender gender, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;
    }

    public Person() {
        this(null, null, null, null, null, null);
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws SQLException {
        this.firstName = firstName;

        String query = "update " + this.getClass().getName() + " " +
        "set fname = '" + getFirstName() + "' " +
                "where id = '" + getId() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) throws SQLException {
        this.middleName = middleName;

        String query = "update " + this.getClass().getName() + " " +
                "set mname = '" + getMiddleName() + "' " +
                "where id = '" + getId() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws SQLException {
        this.lastName = lastName;

        String query = "update " + this.getClass().getName() + " " +
                "set lname = '" + getLastName() + "' " +
                "where id = '" + getId() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) throws SQLException {
        this.gender = gender;

        String query = "update " + this.getClass().getName() + " " +
                "set gender = '" + getGender() + "' " +
                "where id = '" + getId() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws SQLException {
        this.phone = phone;

        String query = "update " + this.getClass().getName() + " " +
                "set phone = " + getPhone() + " " +
                "where id = '" + getId() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    @Override
    public int compareTo(Object o) {
        if(o != null) {
            if(o instanceof Person) {
                Person person = (Person) o;
                return this.id.compareTo(person.getId());
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
